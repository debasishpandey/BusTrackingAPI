package org.trackit.bustracking.config;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig {
//    @Autowired
//   UserDetailsService facultyService;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(request -> request
//                        .requestMatchers("/register").permitAll() // allow without auth
//                        .anyRequest().authenticated() // all other requests require auth
//                )
//                .httpBasic(Customizer.withDefaults())
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authenticationProvider(authenticationProvider())
//                .build();
//    }
//
//
//
//
//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
//        authenticationManagerBuilder.userDetailsService(facultyService)  // Ensures FacultyService is used
//               ;
//        return authenticationManagerBuilder.build();
//    }
//
//    @Bean
//  public AuthenticationProvider authenticationProvider() {
//      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
//        authProvider.setUserDetailsService(facultyService);
//      return authProvider;
//  }

}
