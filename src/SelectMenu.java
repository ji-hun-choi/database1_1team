import Menu.AdminMenu;
import Menu.PersonMenu;
import Service.PersonService;

import java.util.Scanner;

public class SelectMenu {

    private PersonService pservice;

    public SelectMenu() {pservice = new PersonService();}

    public void run(Scanner sc){
        boolean flag = true;
        int c;
        while (flag) {
            System.out.println("1.ȸ������ | 2.IDã�� | 3.��й�ȣã�� | 4.�α��� | 5.����");
            c = sc.nextInt();
            switch (c) {
                case 1:
                    pservice.insertPeople(sc);
                    break;
                case 2:
                    pservice.peopleSearchId(sc);
                    break;
                case 3:
                    pservice.peopleSearchPwd(sc);
                    break;
                case 4:
                    pservice.peopleLogin(sc);
                    if (pservice.getId().equals("")){
                        break;
                    } else {
                        if (pservice.isAdminCheck()){
                            AdminMenu a = new AdminMenu(pservice);
                            a.run(sc);
                        } else {
                            PersonMenu p = new PersonMenu(pservice);
                            p.run(sc);
                        }
                    }
                    break;
                case 5:
                    flag=false;
            }
        }
    }
}
