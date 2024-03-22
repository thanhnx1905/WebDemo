package dom.refreshtoken;

import java.util.Optional;

public interface RefreshTokenRepository {

	public Optional<RefreshToken> findByKey(String sid);

	public void updateTokenExp(RefreshToken token);

	public void removeByKey(String sid);
	
	public void insertTokenExp(RefreshToken token);

}
