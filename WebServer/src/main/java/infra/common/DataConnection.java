package infra.common;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.Data;

@Data
public class DataConnection {
	@PersistenceContext(unitName = "WebServer")
	public EntityManager em;

	public <T> Optional<T> findByKey(Class<T> entityClass, Object primaryKey) {
		return Optional.ofNullable(this.em.find(entityClass, primaryKey));
	}

	public <T> void removeByKey(Class<T> entityClass, Object primaryKey) {
		findByKey(entityClass, primaryKey).ifPresent(x -> {
			this.em.remove(x);
		});
	}
}
