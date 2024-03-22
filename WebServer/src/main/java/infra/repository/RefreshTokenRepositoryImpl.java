package infra.repository;

import java.util.Optional;

import javax.ejb.Stateless;

import dom.refreshtoken.RefreshToken;
import dom.refreshtoken.RefreshTokenRepository;
import infra.common.DataConnection;
import infra.entity.refreshtoken.ERefreshToken;
import infra.entity.refreshtoken.ERefreshTokenPK;

@Stateless
public class RefreshTokenRepositoryImpl extends DataConnection implements RefreshTokenRepository {

	@Override
	public Optional<RefreshToken> findByKey(String sid) {
		return this.findByKey(ERefreshToken.class, new ERefreshTokenPK(sid)).map(x -> x.toDomain());
	}

	@Override
	public void updateTokenExp(RefreshToken token) {
		this.em.merge(ERefreshToken.toEntity(token));
	}

	@Override
	public void removeByKey(String sid) {
		this.removeByKey(ERefreshToken.class, new ERefreshTokenPK(sid));
	}

	@Override
	public void insertTokenExp(RefreshToken token) {
		this.em.persist(ERefreshToken.toEntity(token));
	}

}
