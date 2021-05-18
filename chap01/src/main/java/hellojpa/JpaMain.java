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

        // 엔티티 매니저에서 수행하는 모든 로직은 트랜잭션 안에서 수행되어야 한다.
        entityTransaction.begin();

        try {
//            // 데이터 삽입
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("helloA");
//            // 엔티티 매니저의 영속성 컨텍스트에 위에서 만든 member 객체가 저장된다
//            // 이제 member 엔티티는 엔티티 매니저의 관리 대상이 되고, 영속성을 가졌다고 말할 수 있다
//            entityManager.persist(member);
//            entityTransaction.commit();

//            // 데이터 삭제
//            Member findMember = entityManager.find(Member.class, 2L);
//            entityManager.remove(findMember);
//            entityTransaction.commit();

//            // 데이터 검색
//            Member findMember = entityManager.find(Member.class, 2L);
//            entityManager.remove(findMember);
//            entityTransaction.commit();


            // 데이터 수정
//            Member findMember = entityManager.find(Member.class, 2L);
//            findMember.setName("helloJPA");
//            entityTransaction.commit();

//            // JPQL
//            // table을 대상으로 코드를 짜지 않는다. Member 객체를 대상으로 쿼리를 짠다. 여기서 Member는 객체이다
//            List<Member> result = entityManager.createQuery("select m from Member as m", Member.class)
//                    .getResultList();
//
//            for(Member member : result){
//                System.out.println("member.name = " + member.getName());
//            }
//
//            entityTransaction.commit();

            // 비영속 상태
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("helloJpa");
//
//            // 영속 상태
//            // 엔티티 메니저 안에 있는 엔티티 컨텍스트라는 곳에서 member가 관리된다
//            // 사실은 이 때 db에 저장되는 것은 아니다
//            System.out.println("===Before==");
//            entityManager.persist(member);
//            System.out.println("==After==");
//
//            Member findMember = entityManager.find(Member.class, 101L);
//            System.out.println("findMember.getId() : " + findMember.getId());
//            System.out.println("findMember.getName() : " + findMember.getName());
//
//            entityTransaction.commit();

//            Member findMember1 = entityManager.find(Member.class, 101L);
//            findMember1.setName("updateName");
//
//            entityTransaction.commit();
//
//            Member member = new Member(200L, "member200");
//            entityManager.persist(member);
//
//            entityManager.flush();
//            System.out.println("-==============");
            entityTransaction.commit();

        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
// JPA에서는 트랜잭션이라는 단위가 매우 중요하다.
// 데이터를 변경하는 모든 작업은 반드시 트랜잭션 안에서 수행되어야 한다
