package net.gukinon.learnJWT.security;

import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import net.gukinon.learnJWT.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;

@Component
public class JwtTokenProvider {
    @Autowired
    UserDetailsService userDetailsService;
    public String generateToken(String username, Role role){
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("role",role.getName());
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime()+ SecurityConstants.JWT_EXPIRATION);

        String token = Jwts.builder().
                setClaims(claims).
                setIssuedAt(currentDate).
                setExpiration(expireDate).
                signWith(SignatureAlgorithm.HS512, SecurityConstants.JWT_SECRET)
                .compact();
        return token;
    }
    public Authentication getAuthentication(String token){
        UserDetails userDetails = userDetailsService.loadUserByUsername(getUsernameFromJWT(token));
        return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
    }
    public String getUsernameFromJWT(String token){
        Claims claims =Jwts.parser()
                .setSigningKey(SecurityConstants.JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
    public String resolveToken(HttpServletRequest request) {
        String headerToken = request.getHeader("Authentication");
        if(StringUtils.hasText(headerToken)){
            return headerToken;
        }
        return null;
    }
    public boolean validateToken(String token){
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(SecurityConstants.JWT_SECRET).parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        }
        catch (Exception ex) {
            throw new AuthenticationCredentialsNotFoundException("JWT incorrect");
        }
    }
}
