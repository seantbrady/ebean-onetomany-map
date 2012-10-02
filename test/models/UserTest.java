package models;

import org.junit.Test;

import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

public class UserTest {

    @Test
    public void createAndRetrieveShouldSucceed() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                User u = new User();
                u.save();

                User u2 = u.find.byId(u.getId());
                assertThat(u2).isNotNull();
            }
        });
    }

    @Test
    public void createAndModifyStringShouldSucceed() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                User u = new User();
                u.save();

                User u2 = u.find.byId(u.getId());
                assertThat(u2).isNotNull();

                u2.setName("Charlie Brown");
                u2.save();

                User u3 = u.find.where().idEq(u.getId()).findUnique();
                assertThat(u3.getName()).isEqualTo("Charlie Brown");
            }
        });
    }

    @Test
    public void createAndModifyStringWithEmptyMapShouldSucceed() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                User u = new User();
                u.save();

                User u2 = u.find.byId(u.getId());
                assertThat(u2).isNotNull();

                u2.setName("Charlie Brown");
                u2.save();

                User u3 = u.find.where().idEq(u.getId()).findUnique();
                assertThat(u3.getName()).isEqualTo("Charlie Brown");
                Map<Long, Role> listMap = u3.getRoles();
                assertThat(u3.getRoles()).isNullOrEmpty();
            }
        });
    }

    @Test
    public void createAndModifyStringWithOneRoleListInMapShouldSucceed() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                User u = new User();
                u.save();

                User u2 = u.find.byId(u.getId());
                assertThat(u2).isNotNull();

                u2.setName("Charlie Brown");
                Role ourl = new Role();
                ourl.setOrganizationId(47L);
//                ourl.save();
                u2.getRoles().put(ourl.getOrganizationId(), ourl);
                u2.save();
//                u2.saveManyToManyAssociations("roles");

                User u3 = u.find.where().idEq(u.getId()).findUnique();
                assertThat(u3.getName()).isEqualTo("Charlie Brown");
                Map<Long, Role> listMap = u3.getRoles();
                assertThat(listMap).hasSize(1);
            }
        });
    }
}
