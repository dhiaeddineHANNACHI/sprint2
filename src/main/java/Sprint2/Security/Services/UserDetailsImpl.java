package Sprint2.Security.Services;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import Sprint2.entities.User;

public class UserDetailsImpl implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	private int id;

	
	private String nom;

	
	private String prenom;

	
	private String username;

	
	private String email;

	
	private String adresse;

	@JsonIgnore
	private String password;

		private Collection<? extends GrantedAuthority> authorities;
		
		public UserDetailsImpl(int id, String nom, String prenom, String username, String email, String password, String adresse, 
				Collection<? extends GrantedAuthority> authorities) {
			this.id = id;
			this.nom = nom;
			this.prenom = prenom;
			this.username = username;
			this.email = email;
			this.adresse = adresse;
			this.password = password;			
			this.authorities = authorities;
		}
		
		public static UserDetailsImpl build(User user) {
			List<GrantedAuthority> authorities = user.getRoles().stream()
					.map(role -> new SimpleGrantedAuthority(role.getName().name()))
					.collect(Collectors.toList());

			return new UserDetailsImpl(
					user.getId(),
					user.getNom(),
					user.getPrenom(),
					user.getUsername(), 
					user.getEmail(),
					user.getPassword(),
					user.getAdresse(),
					authorities);
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		@Override
		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getAdresse() {
			return adresse;
		}

		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}

		@Override
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return authorities;
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			UserDetailsImpl other = (UserDetailsImpl) obj;
			if (id != other.id)
				return false;
			return true;
		}

	
	}
		


