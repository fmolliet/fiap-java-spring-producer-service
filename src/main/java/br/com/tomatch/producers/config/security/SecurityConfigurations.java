package br.com.tomatch.producers.config.security;

/*
@EnableWebSecurity
@Configuration
@Profile(value = {"prod", "test"})
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// usamos o metodo userDetailsService para dizer ao spring qual é classe que tem a lógica de autentificação
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/").permitAll() // Somente iremos liberar o metodo GET
			.antMatchers(HttpMethod.GET, "/*").permitAll()
			.antMatchers(HttpMethod.POST, "/").permitAll()
			.antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
			.antMatchers(HttpMethod.GET, "/instances/**").permitAll()
			// Quando o perfil for moderador Não precisa do ROLE_ antes de moderador
			// É possível restringir o acesso a determinados endpoints da aplicação, de acordo com o perfil do usuário autenticado, 
			// utilizando o método hasRole(“NOME_DO_ROLE”) nas configurações de segurança da aplicação. 
			.antMatchers(HttpMethod.DELETE, "/*").hasRole("MODERADOR")
			// Usamos o AnyRequest().authenticated() para dizer ao spring que todas requests nao mapeadas acima precisam de autentificação
			.anyRequest().authenticated()
			.and().csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			// Adicionamos antes o filtro que vai realizar a autentificacao do JWT antes de username e senha
			//.and().addFilterBefore(new AutenticacaoViaTokenFilter( tokenService, usuarioRepository), UsernamePasswordAuthenticationFilter.class);
			// Para usar o formulario padrao para autentificação do spring .and().formLogin();
			//Assim libera todos os metodos do "/topicos" .antMatchers("/topicos").permitAll();
	}

}*/
