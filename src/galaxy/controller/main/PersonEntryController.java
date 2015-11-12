package galaxy.controller.main;

import galaxy.model.PersonModel;
import galaxy.service.PersonalEntryService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.BeanUtil;

public class PersonEntryController extends Controller {

    @Override
    public Navigation run() throws Exception {
        if (!isPost()) {
            return forward("PersonalEntryView");
        }
        
        PersonModel personData = new PersonModel();
        
        BeanUtil.copy(request, personData);
        
        // テストデータ
        personData.setUserId("test@gmail.com");
        
        PersonalEntryService personService = new PersonalEntryService();
        
        personService.insert(personData);
        
        return redirect("PersonalEntryView");
    }
}
