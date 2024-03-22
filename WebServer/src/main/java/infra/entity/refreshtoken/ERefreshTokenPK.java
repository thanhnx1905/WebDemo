package infra.entity.refreshtoken;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ERefreshTokenPK implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "SID")
	public String employeeID;

}