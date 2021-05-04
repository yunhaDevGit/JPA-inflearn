package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        // persistenceUnitName은 META-INF/persistence.xml에서 설정한 persistence-unit의 name이다
        // EntityManagerFactory는 어플리케이션 로딩 시점에 딱 한번만 만든다
        // 트랜잭션 단위를 수행할 때마다 db 커넥션을 얻어서 쿼리를 날리고 종료되는 일관적인 단위를 할 때마다 EntityManager를 만들어야 한다
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Member member = new Member();
        member.setId(2L);
        member.setName("helloB");

        entityManager.persist(member);

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
// JPA에서는 트랜잭션이라는 단위가 매우 중요하다.
// 데이터를 변경하는 모든 작업은 반드시 트랜잭션 안에서 수행되어야 한다
