package galaxy.service;

import galaxy.model.PersonModel;

import java.util.List;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PersonalEntryTest extends AppEngineTestCase {

    private PersonalEntryService service = new PersonalEntryService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
        
        List<PersonModel> personList = service.getAll(); 
        // ========== assertion start ========== //
        // �����0���ł��邱��
        assertNotNull(personList);
        assertTrue(personList.isEmpty());
        // ========== assertion end ========== //
        
        // ���[�U�[�̍쐬
        PersonModel personData = new PersonModel();
        personData.setUserId("wondringwonder@gmail.com");
        personData.setUserName("�e�X�g���[�U�[");
        personData.setMailto("wondringwonder@gmail.com");
        personData.setBumon("B001");
        personData.setTeam("T001");
        personData.setOther("");
        personData.setUserCode("342");
        
        // �f�[�^�X�g�A�֍X�V
        service.insert(personData);
        
        // �f�[�^�o�^����Ă��鎖
        personList = service.getAll();
        // ========== assertion start ========== //
        // �����0���ł��邱��
        assertNotNull(personList);
        assertTrue(personList.size() == 1);
        // ========== assertion end ========== //
        
        // �ȍ~�A1���̒��g�̃`�F�b�N
        PersonModel storedPerson = personList.get(0);
        assertNotNull(storedPerson);
        // ���[�U�[ID�A���[�U�[���A���[���A�h���X�A����R�[�h�A�`�[���R�[�h�A���̑��R�[�h�A���[�U�[�R�[�h���������ۑ�����Ă��邩
        assertEquals(personData.getUserId(), storedPerson.getUserId());
        assertEquals(personData.getUserName(), storedPerson.getUserName());
        assertEquals(personData.getMailto(), storedPerson.getMailto());
        assertEquals(personData.getBumon(), storedPerson.getBumon());
        assertEquals(personData.getTeam(), storedPerson.getTeam());
        assertEquals(personData.getOther(), storedPerson.getOther());
        assertEquals(personData.getUserCode(), storedPerson.getUserCode());
        
        // ========== assertion end ========== //
        
        // ===================================== 
        // �X�V�e�X�g 
        // ===================================== 
        // �L���̕ύX 
        personData.setUserName("�X�V���[�U�[�P");
        // �f�[�^�X�g�A�֏㏑���X�V 
        service.update(personData);
        // �X�V��̃f�[�^�ꗗ�̎擾 
        personList = service.getAll();
        // ========== assertion start ========== // 
        // �X�V��̃f�[�^��1���ł��邱�� 
        assertNotNull(personList);
        assertTrue(personList.size() == 1);
        // �ȍ~�A1���̒��g�̃`�F�b�N 
        PersonModel updatedPerson = personList.get(0);
        // �C������Person�ƁA�X�V��Ď擾����Person������������ 
        assertEqualsPerson(personData, updatedPerson);
        // �㏑���X�V�����̂Ńo�[�W������2�ɂȂ��Ă��邱�� 
        assertEquals(updatedPerson.getVersion(), Long.valueOf(2L));
        // ========== assertion end ========== //
        
        // ===================================== 
        // ���[�U�[�̍폜 
        // ===================================== 
        // ���[�U�[�̍폜 
        service.delete(updatedPerson.getKey());
        // �폜��̃��[�U�[�̎擾 
        storedPerson = service.get(updatedPerson.getKey());
        // �폜��̋L���ꗗ�̎擾 
        personList   = service.getAll();
        // ========== assertion start ========== // 
        // ���̋L���͍폜����Ă���̂�Null�ł��邱�� 
        assertNull(storedPerson);
        // �L���ꗗ�͂O���̃��X�g�ł��邱�� 
        assertNotNull(personList);
        assertTrue(personList.isEmpty());
        // ========== assertion end ========== //         
        
    }
    
    private void assertEqualsPerson(PersonModel person1, PersonModel person2) {
        // ����Null�ł͂Ȃ����� 
        assertNotNull(person1);
        assertNotNull(person2);
        // �e�f�[�^������������ 
        assertEquals(person1.getUserId(), person2.getUserId());
        assertEquals(person1.getUserName(), person2.getUserName());
        assertEquals(person1.getMailto(), person2.getMailto());
        assertEquals(person1.getBumon(), person2.getBumon());
        assertEquals(person1.getTeam(), person2.getTeam());
        assertEquals(person1.getOther(), person2.getOther());
        assertEquals(person1.getUserCode(), person2.getUserCode());
    }    
}
