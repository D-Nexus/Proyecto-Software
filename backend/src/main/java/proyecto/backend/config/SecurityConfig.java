package proyecto.backend.config;

import proyecto.backend.service.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(http -> {
                    // Cofnigurar los endpoints privados
                    http.requestMatchers(HttpMethod.GET, "/api/proyectos/getAll").hasAnyRole("ADMIN", "USER");
                    http.requestMatchers(HttpMethod.GET, "/api/proyectos/SearchByID/*").hasAnyRole("ADMIN", "USER");
                    http.requestMatchers(HttpMethod.POST, "/api/proyectos/create").hasAnyRole("ADMIN", "USER");
                    http.requestMatchers(HttpMethod.PUT, "/api/proyectos/update/*").hasAnyRole("ADMIN", "USER");
                    http.requestMatchers(HttpMethod.DELETE, "/api/proyectos/delete/*").hasAnyRole("ADMIN", "USER");
                    http.requestMatchers(HttpMethod.GET, "/api/empleados/getAll").hasAnyRole("ADMIN", "USER");
                    http.requestMatchers(HttpMethod.GET, "/api/empleados/SearchByID/*").hasAnyRole("ADMIN", "USER");
                    http.requestMatchers(HttpMethod.POST, "/api/empleados/create").hasAnyRole("ADMIN", "USER");
                    http.requestMatchers(HttpMethod.PUT, "/api/empleados/update/*").hasAnyRole("ADMIN", "USER");
                    http.requestMatchers(HttpMethod.DELETE, "/api/empleados/delete/*").hasAnyRole("ADMIN", "USER");
                    http.requestMatchers(HttpMethod.GET, "/api/registros/getAll").hasAnyRole("ADMIN", "USER");
                    http.requestMatchers(HttpMethod.GET, "/api/registros/SearchByID/*").hasAnyRole("ADMIN", "USER");
                    http.requestMatchers(HttpMethod.POST, "/api/registros/calcularBono").hasAnyRole("ADMIN", "USER");
                    http.requestMatchers(HttpMethod.PUT, "/api/registros/update/*").hasAnyRole("ADMIN", "USER");
                    http.requestMatchers(HttpMethod.DELETE, "/api/registros/delete/*").hasAnyRole("ADMIN", "USER");

                    // Configurar el resto de endpoint - NO ESPECIFICADOS
                    http.anyRequest().denyAll();
                })
                .build();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//                .csrf(csrf -> csrf.disable())
//                .httpBasic(Customizer.withDefaults())
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .build();
//    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailServiceImpl userDetailService){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailService);
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}