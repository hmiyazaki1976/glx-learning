package galaxy.service;

import galaxy.model.PersonModel;

import java.util.List;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class personalentryTest extends AppEngineTestCase {

    private PersonalEntryService service = new PersonalEntryService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
        
        List<PersonModel> personList = service.getAll(); 
        // ========== assertion start ========== //
        // 初回は0件であること
        assertNotNull(personList);
        assertTrue(personList.isEmpty());
        // ========== assertion end ========== //
        
        // ユーザーの作成
        PersonModel personData = new PersonModel();
        personData.setUserId("wondringwonder@gmail.com");
        personData.setUserName("テストユーザー");
        personData.setMailto("wondringwonder@gmail.com");
        personData.setBumon("B001");
        personData.setTeam("T001");
        personData.setOther("");
        personData.setUserCode("342");
        
        // データストアへ更新
        service.insert(personData);
        
        // データ登録されている事
        personList = service.getAll();
        // ========== assertion start ========== //
        // 初回は0件であること
        assertNotNull(personList);
        assertTrue(personList.size() == 1);
        // ========== assertion end ========== //
        
        // 以降、1件の中身のチェック
        PersonModel storedPerson = personList.get(0);
        assertNotNull(storedPerson);
        // ユーザーID、ユーザー名、メールアドレス、部門コード、チームコード、その他コード、ユーザーコードが正しく保存されているか
        assertEquals(personData.getUserId(), storedPerson.getUserId());
        assertEquals(personData.getUserName(), storedPerson.getUserName());
        assertEquals(personData.getMailto(), storedPerson.getMailto());
        assertEquals(personData.getBumon(), storedPerson.getBumon());
        assertEquals(personData.getTeam(), storedPerson.getTeam());
        assertEquals(personData.getOther(), storedPerson.getOther());
        assertEquals(personData.getUserCode(), storedPerson.getUserCode());
        
        // ========== assertion end ========== //
        
        // ===================================== 
        // 更新テスト 
        // ===================================== 
        // 記事の変更 
        personData.setUserName("更新ユーザー１");
        // データストアへ上書き更新 
        service.update(personData);
        // 更新後のデータ一覧の取得 
        personList = service.getAll();
        // ========== assertion start ========== // 
        // 更新後のデータは1件であること 
        assertNotNull(personList);
        assertTrue(personList.size() == 1);
        // 以降、1件の中身のチェック 
        PersonModel updatedPerson = personList.get(0);
        // 修正したPersonと、更新後再取得したPersonが等しいこと 
        assertEqualsPerson(personData, updatedPerson);
        // 上書き更新したのでバージョンが2になっていること 
        assertEquals(updatedPerson.getVersion(), Long.valueOf(2L));
        // ========== assertion end ========== //
        
        // ===================================== 
        // ユーザーの削除 
        // ===================================== 
        // ユーザーの削除 
        service.delete(updatedPerson.getKey());
        // 削除後のユーザーの取得 
        storedPerson = service.get(updatedPerson.getKey());
        // 削除後の記事一覧の取得 
        personList   = service.getAll();
        // ========== assertion start ========== // 
        // この記事は削除されているのでNullであること 
        assertNull(storedPerson);
        // 記事一覧は０件のリストであること 
        assertNotNull(personList);
        assertTrue(personList.isEmpty());
        // ========== assertion end ========== //         
        
    }
    
    private void assertEqualsPerson(PersonModel person1, PersonModel person2) {
        // 共にNullではないこと 
        assertNotNull(person1);
        assertNotNull(person2);
        // 各データが等しいこと 
        assertEquals(person1.getUserId(), person2.getUserId());
        assertEquals(person1.getUserName(), person2.getUserName());
        assertEquals(person1.getMailto(), person2.getMailto());
        assertEquals(person1.getBumon(), person2.getBumon());
        assertEquals(person1.getTeam(), person2.getTeam());
        assertEquals(person1.getOther(), person2.getOther());
        assertEquals(person1.getUserCode(), person2.getUserCode());
    }    
}
