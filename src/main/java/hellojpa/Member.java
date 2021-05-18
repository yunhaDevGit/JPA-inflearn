package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "team_id")
    private Long teamId;
}
