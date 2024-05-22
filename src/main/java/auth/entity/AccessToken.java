package auth.entity;

import java.util.Date;

import global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class AccessToken extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String jti;

	@Column
	private String token;

	@Column
	private Date expiresAt;

	@Column(columnDefinition = "boolean default false")
	private boolean isRevoke;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
}
