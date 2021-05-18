package java.hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chapter03");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        try {
            Team team = new Team();
            team.setName("teamA");
            entityManager.persist(team);

            Member member = new Member();
            member.setUsername("member");
            member.setTeam(team);
            entityManager.persist(member);

            // 1차 캐시가 아닌 DB로부터 값을 가지고 오고 싶은 경우
            entityManager.flush(); // 영속성 컨텍스트에 있는 쿼리를 DB에 날려 동기화
            entityManager.clear(); // 영속성 컨텍스트 초기화

            Member findMember = entityManager.find(Member.class, member.getId());

            Team findTeam = findMember.getTeam();
            System.out.println("findTeam = " + findTeam.getName());

            entityTransaction.commit();

        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
