package galaxy.controller.main;

import java.util.List;

import galaxy.model.PersonModel;
import galaxy.service.PersonalEntryService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class PersonalEntryViewController extends Controller {

    @Override
    public Navigation run() throws Exception {
        //PersonalEntryService service = new PersonalEntryService();
        //List<PersonModel> personList = service.getAll();
        //requestScope("personList", personList);
        return forward("PersonalEntryView.jsp");
    }
}
