package repository;

import java.util.Optional;

import javax.ejb.Stateless;

import refreshtoken.RefreshToken;
import refreshtoken.RefreshTokenRepository;
import common.DataConnection;
import entity.refreshtoken.ERefreshToken;
import entity.refreshtoken.ERefreshTokenPK;

@Stateless
public class RefreshTokenRepositoryImpl extends DataConnection implements RefreshTokenRepository {

	@Override
	public Optional<RefreshToken> findByKey(String tokenId) {
		return this.findByKey(ERefreshToken.class, new ERefreshTokenPK(tokenId)).map(x -> x.toDomain());
	}

	@Override
	public void updateTokenExp(RefreshToken token) {
		this.em.merge(ERefreshToken.toEntity(token));
	}

	@Override
	public void removeByKey(String tokenId) {
		this.removeByKey(ERefreshToken.class, new ERefreshTokenPK(tokenId));
		this.em.flush();
	}

	@Override
	public void insertTokenExp(RefreshToken token) {
		this.em.persist(ERefreshToken.toEntity(token));
	}

}
