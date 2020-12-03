package mre.spring.facture.services;

import mre.spring.facture.models.OtherUser;

public interface OtherUserServiceInterface {

    OtherUser save(OtherUser otherUser);
    OtherUser update(Long id, OtherUser otherUser);
    Iterable<OtherUser> allOtherUsers();
    OtherUser getById(Long id);
    void delete(OtherUser otherUser);
}
