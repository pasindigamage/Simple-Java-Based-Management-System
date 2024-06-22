import java.util.Scanner;

public class Demo {
        static Scanner input = new Scanner(System.in);
        static String usrName1 = "pasindi";
        static String pwd1 = "1234";
        static String[][] addSupplierArr = new String[0][2];
        static String [] itemCategory = new String[0];
        static String [][] item = new String[0][6];

        public static void rankItemPerUnitPrice(){


            for (int i = 0; i < item.length - 1; i++){
                for (int j = i + 1; j < item.length; j++){
                    if (Integer.parseInt(item[i][4]) > Integer.parseInt(item[j][4])){
                        for (int k = 0; k < item[i].length; k++){
                            String Temp = item[i][k];
                            item[i][k] = item[j][k];
                            item[j][k] = Temp;
                        }

                    }
                }

            }

            clearConsole();
            System.out.println("+-----------------------------------------------------------------------+");
            System.out.println("|\t\t\t\tRANKED UNIT PRICE\t\t\t|");
            System.out.println("+-----------------------------------------------------------------------+\n");

            System.out.printf("+-----------------------------------------------------------------+%n");
            System.out.printf("|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s|%n","   SID","   CODE","  DESC","  PRICE","   QTY","   CAT");
            System.out.printf("+-----------------------------------------------------------------+%n");

            for(int i = 0; i < item.length; i++){

                System.out.printf("|%-10s|%-10s|%-10s|%-10s|%-10s|%-10s|%n","  "+item[i][1],"  "+item[i][0],"  "+item[i][3],"   "+item[i][4],"   "+item[i][5],"   "+item[i][2]);
            }
            System.out.printf("+-----------------------------------------------------------------+%n");

            System.out.print("Do you want to go stock manage page?(Y/N) ");
            String option = input.next();

            if(option.equals("y")||option.equals("Y")){
                clearConsole();
                stockManage();
            }

            if(option.equals("n")||option.equals("N")){
                clearConsole();
                rankItemPerUnitPrice();
            }
        }

        public static void viewItem(){
            clearConsole();
            System.out.println("+-----------------------------------------------------------------------+");
            System.out.println("|\t\t\t\tVIEW ITEMS\t\t\t\t|");
            System.out.println("+-----------------------------------------------------------------------+\n");

            for(int i = 0; i < itemCategory.length;i++){
                System.out.println(itemCategory[i]+":");
                System.out.printf("+------------------------------------------------------+%n");
                System.out.printf("|%-10s|%-10s|%-10s|%-10s|%-10s|%n","   SID","   CODE","   DESC","  PRICE","   QTY");
                System.out.printf("+------------------------------------------------------+%n");

                for (int j = 0; j < item.length; j++){
                    if (itemCategory[i].equals(item[j][2])){
                        System.out.printf("|%-10s|%-10s|%-10s|%-10s|%-10s|%n","   "+item[j][1],"   "+item[j][0],"   "+item[j][3],"   "+item[j][4],"   "+item[j][5]);
                        System.out.println();
                    }
                }
                System.out.printf("+------------------------------------------------------+%n");
            }
            System.out.println();
            System.out.print("Do you want to go stock manage page?(Y/N) ");
            String option = input.next();

            if(option.equals("y")||option.equals("Y")){
                clearConsole();
                stockManage();
            }

            if(option.equals("n")||option.equals("N")){
                clearConsole();
                homePage();
            }
        }

        public static void getItemsSupplierWise(){
            clearConsole();
            System.out.println("+-----------------------------------------------------------------------+");
            System.out.println("|\t\t\tSEARCH ITEMS SUPPLIER WISE\t\t\t|");
            System.out.println("+-----------------------------------------------------------------------+\n");

            System.out.print("Enter Supplier Id: ");
            String supId = input.next();

            for(int i = 0; i < addSupplierArr.length; i++){
                if(addSupplierArr[i][0].equals(supId)){
                    System.out.println("Supplier Name: "+addSupplierArr[i][1]);
                    System.out.println();
                }
            }

            System.out.printf("+--------------------------------------------------------------------------------------------------------+%n");
            System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%n","    ITEM CODE","    DESCRIPTION","    UNIT PRICE","   QTY ON HAND","   CATEGORY");
            System.out.printf("+--------------------------------------------------------------------------------------------------------+%n");


            for (int i = 0; i < item.length; i++){
                if(item[i][1].equals(supId)){
                    System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%n","    "+item[i][0],"    "+item[i][3],"    "+item[i][4],"   "+item[i][5],"   "+item[i][3]);
                }
            }
            System.out.printf("+--------------------------------------------------------------------------------------------------------+%n");


            System.out.print("search successfully! Do you want to another search?(Y/N) ");
            String option = input.next();

            if(option.equals("y")||option.equals("Y")){
                clearConsole();
                getItemsSupplierWise();
            }

            if(option.equals("n")||option.equals("N")){
                clearConsole();
                stockManage();
            }


        }

        public static String[][] growItem(){
            String [][] temp = new String [item.length+1][6];

            for (int i = 0; i < item.length; i++){
                for (int j = 0; j < item[i].length; j++){
                    temp[i][j] = item[i][j];
                }
            }
            return temp;
        }

        public static void addItem(){
            clearConsole();
            System.out.println("+-----------------------------------------------------------------------+");
            System.out.println("|\t\t\t\tADD ITEM \t\t\t\t|");
            System.out.println("+-----------------------------------------------------------------------+\n");

            if(itemCategory.length == 0){
                System.out.println("OOPS! It seems that you don't have any item categories in the system.");
                System.out.print("Do you want to add a new item category?(Y/N) ");
                String option = input.next();

                if(option.equals("Y")||option.equals("y")){
                    addNewItemCategory();
                }

                if(option.equals("N")||option.equals("n")){
                    stockManage();
                }

            }

            if(addSupplierArr.length == 0){
                clearConsole();
                System.out.println("+-----------------------------------------------------------------------+");
                System.out.println("|\t\t\t\tADD ITEM \t\t\t\t|");
                System.out.println("+-----------------------------------------------------------------------+\n");

                System.out.println("OOPS! It seems that you don't have any suppliers in the system.");
                System.out.print("Do you want to add a new supplier?(Y/N) ");
                String option = input.next();

                if(option.equals("Y")||option.equals("y")){
                    addSupplierDetail();
                }

                if(option.equals("N")||option.equals("n")){
                    supplierManage();
                }

            }

            clearConsole();
            System.out.println("+-----------------------------------------------------------------------+");
            System.out.println("|\t\t\t\tADD ITEM \t\t\t\t|");
            System.out.println("+-----------------------------------------------------------------------+\n");

            while(true){

                boolean sw = true;

                System.out.print("Item Code        : ");
                String itemCode = input.next();

                for (int i = 0; i < item.length; i++){
                    if(itemCode.equals(item[i][0])){
                        System.out.println("already added. try another item code!\n");
                        sw = false;
                        break;
                    }
                }

                if(sw){
                    item = growItem();
                    item[item.length-1][0] = itemCode;
                    System.out.println();




                    System.out.println("Suppliers list:");

                    System.out.printf("+--------------------------------------------------------------+%n");
                    System.out.printf("|%-10s|%-25s|%-25s|%n","    #","        Supplierid","     SUPPLIER NAME");
                    System.out.printf("+--------------------------------------------------------------+%n");

                    for (int i = 0; i < addSupplierArr.length; i++){
                        System.out.printf("|%-10s|%-25s|%-25s|%n","    "+(i+1),"        "+addSupplierArr[i][0],"        "+addSupplierArr[i][1]);
                    }
                    System.out.printf("+--------------------------------------------------------------+%n");
                    System.out.println();

                    System.out.print("Enter the supplier number > ");
                    int supId = input.nextInt();

                    item[item.length-1][1] = addSupplierArr[supId-1][0];

                    System.out.println();

                    System.out.println("Item Categories: ");
                    System.out.printf("+------------------------------------+%n");
                    System.out.printf("|%-10s|%-25s|%n","    #","     CATEGORY NAME");
                    System.out.printf("+------------------------------------+%n");

                    for (int i = 0; i < itemCategory.length; i++){
                        System.out.printf("|%-10s|%-25s|%n","    "+(i+1),"        "+itemCategory[i]);
                    }
                    System.out.printf("+------------------------------------+%n");
                    System.out.println();

                    System.out.print("Enter the category number > ");
                    int categoryId = input.nextInt();

                    item[item.length-1][2] = itemCategory[categoryId-1];

                    System.out.println();
                    System.out.print("Description : ");
                    item[item.length-1][3] = input.next();

                    System.out.print("Unit Price  : ");
                    item[item.length-1][4] = input.next();

                    System.out.print("Qty on hand : ");
                    item[item.length-1][5] = input.next();

                    System.out.print("added sucessfully! Do you want to add another Item(Y/N)? ");
                    String option = input.next();

                    if(option.equals("y")||option.equals("Y")){
                        clearConsole();
                        addItem();
                    }

                    if(option.equals("n")||option.equals("N")){
                        clearConsole();
                        stockManage();
                    }
                }
            }
        }

        public static void updateItemCategory(){

            clearConsole();
            System.out.println("+-----------------------------------------------------------------------+");
            System.out.println("|\t\t\tUPDATE ITEM CATEGORY\t\t\t\t|");
            System.out.println("+-----------------------------------------------------------------------+\n");


            boolean sw = true;

            System.out.print("Update item category : ");
            String category = input.next();

            for (int i = 0; i < itemCategory.length; i++){
                if (itemCategory[i].equals(category)){
                    System.out.println("Item category : "+itemCategory[i]);
                    System.out.println();

                    System.out.print("Enter the new item category : ");
                    itemCategory[i] = input.next();
                    sw = false;
                    break;
                }
            }

            while(sw){
                System.out.println("can't find item category. try again!");
                System.out.println();

                System.out.print("Update item category : ");
                category = input.next();

                for (int i = 0; i < itemCategory.length; i++){
                    if (itemCategory[i].equals(category)){
                        System.out.println("Item category : "+itemCategory[i]);
                        System.out.println();

                        System.out.print("Enter the new item category : ");
                        itemCategory[i] = input.next();
                        sw = false;
                        break;
                    }
                }
            }

            System.out.print("Updated successfully! Do you want to update another item category ? (Y/N) ");
            String option = input.next();


            if(option.equals("y")||option.equals("Y")){
                clearConsole();
                updateItemCategory();
            }

            if(option.equals("n")||option.equals("N")){
                clearConsole();
                manageItemCategories();
            }
        }

        public static void deleteItemCategory(){
            clearConsole();
            System.out.println("+-----------------------------------------------------------------------+");
            System.out.println("|\t\t\t\tDELETE ITEM CATEGORY\t\t\t|");
            System.out.println("+-----------------------------------------------------------------------+\n");

            boolean sw = true;

            System.out.print("Delete item category : ");
            String category = input.next();

            for (int i = 0; i < itemCategory.length; i++){
                if (itemCategory[i].equals(category)){
                    if (!itemCategory[i].equals(category)){
                        String temp[]  = new String [itemCategory.length-1];
                        for (int j = 0; i < itemCategory.length; j++){
                            temp[j] = itemCategory[i];
                            j++;
                        }
                    }
                    sw = false;
                    break;
                }

            }


            while(sw){
                System.out.println("can't find category. try again!");
                System.out.println();

                System.out.print("Delete item category : ");
                category = input.next();

                for (int i = 0; i < itemCategory.length; i++){
                    if (itemCategory[i].equals(category)){
                        if (!itemCategory[i].equals(category)){
                            String temp[]  = new String [itemCategory.length-1];
                            for (int j = 0; i < itemCategory.length; j++){
                                temp[j] = itemCategory[i];
                                j++;
                            }
                        }
                        sw = false;
                        break;
                    }

                }
            }

            System.out.print("Deleted successfully! Do you want to delete another category? (Y/N) ");
            String option = input.next();



            if(option.equals("y")||option.equals("Y")){
                clearConsole();
                deleteItemCategory();
            }

            if(option.equals("n")||option.equals("N")){
                clearConsole();
                manageItemCategories();
            }
        }

        public static String[] growItemArr(){
            String [] newArr = new String [itemCategory.length+1];
            for (int i = 0; i < itemCategory.length; i++){
                newArr[i] = itemCategory[i];

            }

            return newArr;
        }

        public static void addNewItemCategory(){
            clearConsole();
            System.out.println("+-----------------------------------------------------------------------+");
            System.out.println("|\t\t\tADD ITEM CATEGORY\t\t\t\t|");
            System.out.println("+-----------------------------------------------------------------------+\n");

            itemCategory = growItemArr();

            System.out.print("Enter the new item category: ");
            itemCategory[itemCategory.length-1] = input.next();

            System.out.print("added successfully! Do you want to add another category(Y/N)? ");
            String option = input.next();

            if(option.equals("y")||option.equals("Y")){
                clearConsole();
                addNewItemCategory();
            }

            if(option.equals("n")||option.equals("N")){
                clearConsole();
                stockManage();
            }
        }

        public static void manageItemCategories(){
            clearConsole();
            System.out.println("+-----------------------------------------------------------------------+");
            System.out.println("|\t\t\tMANAGE ITEM CATEGORY\t\t\t\t|");
            System.out.println("+-----------------------------------------------------------------------+\n");

            System.out.println("[1] Add New Item Category\t\t[2] Delete Item Category");
            System.out.println("[3] Update Item Category\t\t[4] Stock Management\n");

            System.out.print("Enter an option to continue > ");
            int option = input.nextInt();

            if(option == 1){
                clearConsole();
                addNewItemCategory();
            }

            if(option == 2){
                clearConsole();
                deleteItemCategory();
            }

            if(option == 3){
                clearConsole();
                updateItemCategory();
            }

            if(option == 4){
                clearConsole();
                stockManage();
            }

        }

        public static void stockManage(){
            clearConsole();
            System.out.println("+-----------------------------------------------------------------------+");
            System.out.println("|\t\t\tSTOCK MANAGEMENT\t\t\t\t|");
            System.out.println("+-----------------------------------------------------------------------+\n");

            System.out.println("[1] Manage Item Categories\t\t[2] Add Item");
            System.out.println("[3] Get Item Supplier Wise\t\t[4] View Item");
            System.out.println("[5] Rank Item Per Unit Price\t\t[6] Home Page\n");


            System.out.print("Enter an option to continue > ");
            int option = input.nextInt();

            if(option == 1){
                clearConsole();
                manageItemCategories();
            }

            if(option == 2){
                clearConsole();
                addItem();
            }

            if(option == 3){
                clearConsole();
                getItemsSupplierWise();
            }

            if(option == 6){
                clearConsole();
                homePage();
            }

            if(option == 4){
                clearConsole();
                viewItem();
            }

            if(option == 5){
                clearConsole();
                rankItemPerUnitPrice();
            }

        }

        public static void searchSupplier(){
            clearConsole();
            System.out.println("+-----------------------------------------------------------------------+");
            System.out.println("|\t\t\t\tSEARCH SUPPLIER\t\t\t\t|");
            System.out.println("+-----------------------------------------------------------------------+\n");

            boolean sw = true;

            while(sw){

                System.out.print("Supplier ID      : ");
                String SupId = input.next();

                for (int i = 0; i < addSupplierArr.length; i++){
                    if (addSupplierArr[i][0].equals(SupId)){
                        System.out.println("Supplier Name    : "+addSupplierArr[i][1]);

                        System.out.print("added successfully! Do you want to add another find(Y/N)? ");
                        String option = input.next();

                        if(option.equals("y")||option.equals("Y")){
                            clearConsole();
                            searchSupplier();
                        }

                        if(option.equals("n")||option.equals("N")){
                            clearConsole();
                            supplierManage();

                        }
                    }

                }

                System.out.println("can't find supplier id. try again!");
                System.out.println();

            }
        }

        public static void viewSuppliers(){
            clearConsole();
            System.out.println("+-----------------------------------------------------------------------+");
            System.out.println("|\t\t\t\tVIEW SUPPLIER\t\t\t\t|");
            System.out.println("+-----------------------------------------------------------------------+\n");
            System.out.printf("+---------------------------------------------------+%n");
            System.out.printf("|%-25s|%-25s|%n","        Supplier","     Supplier Name");
            System.out.printf("+---------------------------------------------------+%n");

            for (int i = 0; i < addSupplierArr.length; i++){
                System.out.print("|");
                for (int j = 0; j < addSupplierArr[i].length; j++){
                    System.out.printf("%-25s|","    "+addSupplierArr[i][j]);
                }
                System.out.printf("%n+---------------------------------------------------+%n");
            }

            System.out.print("Do you want to go supplier manage page(Y/N)? ");
            String option = input.next();

            if(option.equals("y")||option.equals("Y")){
                clearConsole();
                supplierManage();
            }

            if(option.equals("n")||option.equals("N")){
                clearConsole();
                homePage();
            }
        }

        public static String [][] remakeArr(){
            int count = 0;
            for (int i = 0; i < addSupplierArr.length; i++){
                if(addSupplierArr[i][0].equals("null")){
                    count++;
                }
            }

            String[][] remakeNewArr = new String[addSupplierArr.length - count][2];

            for (int i = 0, j = 0; i < addSupplierArr.length; i++){
                if(!addSupplierArr[i][0].equals("null")){
                    remakeNewArr[j][0] = addSupplierArr[i][0];
                    remakeNewArr[j][1] = addSupplierArr[i][1];
                    j++;
                }
            }

            return remakeNewArr;
        }

        public static void deleteSupplier(){
            clearConsole();
            System.out.println("+-----------------------------------------------------------------------+");
            System.out.println("|\t\t\t\tDELETE SUPPLIER\t\t\t\t|");
            System.out.println("+-----------------------------------------------------------------------+\n");

            boolean sw = true;

            System.out.print("Supplier ID      : ");
            String SupId = input.next();

            for (int i = 0; i < addSupplierArr.length; i++){
                if (addSupplierArr[i][0].equals(SupId)){
                    addSupplierArr[i][0] = "null";
                    addSupplierArr[i][1] = "null";
                    sw = false;
                    break;
                }
            }


            while(sw){
                System.out.println("can't find supplier id. try again!");
                System.out.println();

                System.out.print("Supplier ID      : ");
                SupId = input.next();

                for (int i = 0; i < addSupplierArr.length; i++){
                    if (addSupplierArr[i][0].equals(SupId)){
                        addSupplierArr[i][0] = "null";
                        addSupplierArr[i][1] = "null";
                        sw = false;
                        break;
                    }
                }
            }

            System.out.print("Deleted successfully! Do you want to delete another? (Y/N) ");
            String option = input.next();
            addSupplierArr = remakeArr();

            if(option.equals("y")||option.equals("Y")){
                clearConsole();
                deleteSupplier();
            }

            if(option.equals("n")||option.equals("N")){
                clearConsole();
                supplierManage();
            }
        }

        public static void updateSupplier(){
            clearConsole();
            System.out.println("+-----------------------------------------------------------------------+");
            System.out.println("|\t\t\t\tUPDATE SUPPLIER\t\t\t\t|");
            System.out.println("+-----------------------------------------------------------------------+\n");


            boolean sw = true;

            System.out.print("Supplier ID      : ");
            String SupId = input.next();

            for (int i = 0; i < addSupplierArr.length; i++){
                if (addSupplierArr[i][0].equals(SupId)){
                    System.out.println("Supplier Name    : "+addSupplierArr[i][1]);
                    System.out.println();

                    System.out.print("Enter the new supplier name : ");
                    addSupplierArr[i][1] = input.next();
                    sw = false;
                    break;
                }
            }

            while(sw){
                System.out.println("can't find supplier id. try again!");
                System.out.println();

                System.out.print("Supplier ID      : ");
                SupId = input.next();

                for (int i = 0; i < addSupplierArr.length; i++){
                    if (addSupplierArr[i][0].equals(SupId)){
                        System.out.println("Supplier Name    : "+addSupplierArr[i][1]);
                        System.out.println();

                        System.out.print("Enter the new supplier name : ");
                        addSupplierArr[i][1] = input.next();
                        sw = false;
                        break;
                    }

                }
            }

            System.out.print("Updated successfully! Do you want to update another supplier? (Y/N) ");
            String option = input.next();


            if(option.equals("y")||option.equals("Y")){
                clearConsole();
                updateSupplier();
            }

            if(option.equals("n")||option.equals("N")){
                clearConsole();
                supplierManage();
            }

        }

        public static String[][] supplierArrGrow() {
            String [][] newArr = new String[addSupplierArr.length + 1][2];

            for (int i = 0; i < addSupplierArr.length; i++){
                newArr[i][0] = addSupplierArr[i][0];
            }

            for (int i = 0; i < addSupplierArr.length; i++){
                newArr[i][1] = addSupplierArr[i][1];
            }

            return newArr;
        }

        public static void addSupplierDetail(){
            clearConsole();
            System.out.println("+-----------------------------------------------------------------------+");
            System.out.println("|\t\t\t\tADD SUPPLIER\t\t\t\t|");
            System.out.println("+-----------------------------------------------------------------------+\n");

            System.out.print("Supplier ID      : ");
            String SupId = input.next();

            boolean sw = false;

            for (int j = 0; j < addSupplierArr.length; j++){
                if(addSupplierArr[j][0].equals(SupId)){
                    sw = true;
                    break;
                }
            }

            while(sw){
                System.out.println("already exists. try another supplier id!");
                System.out.println();

                System.out.print("Supplier ID      : ");
                SupId = input.next();

                sw = false;
                for (int j = 0; j < addSupplierArr.length; j++){
                    if(addSupplierArr[j][0].equals(SupId)){
                        sw = true;
                        break;
                    }
                }
            }

            addSupplierArr = supplierArrGrow();

            addSupplierArr[addSupplierArr.length - 1][0] = SupId;

            System.out.print("Supplier Name    : ");
            addSupplierArr[addSupplierArr.length - 1][1] = input.next();

            System.out.print("added successfully! Do you want to add another supplier(Y/N)? ");
            String option = input.next();


            if(option.equals("y")||option.equals("Y")){
                clearConsole();
                addSupplierDetail();
            }

            if(option.equals("n")||option.equals("N")){
                clearConsole();
                supplierManage();
            }

        }

        public static void supplierManage(){
            clearConsole();
            System.out.println("+-----------------------------------------------------------------------+");
            System.out.println("|\t\t\t\tSUPPLIER MANAGE\t\t\t\t|");
            System.out.println("+-----------------------------------------------------------------------+\n");


            System.out.println("[1] Add Supplier            \t\t[2] Update Supplier");
            System.out.println("[3] Delete Supplier         \t\t[4] View Suppliers");
            System.out.println("[5] Search Supplier         \t\t[6] Home Page\n");

            System.out.print("Enter an option to continue > ");
            int option = input.nextInt();

            if(option == 1){
                addSupplierDetail();
            }

            if(option == 6){
                clearConsole();
                homePage();
            }

            if(option == 2){
                clearConsole();
                updateSupplier();
            }

            if(option == 3){
                clearConsole();
                deleteSupplier();
            }

            if(option == 4){
                clearConsole();
                viewSuppliers();
            }

            if(option == 5){
                clearConsole();
                searchSupplier();
            }


        }

        public static void credentialManage(){
            clearConsole();
            System.out.println("+-----------------------------------------------------------------------+");
            System.out.println("|\t\t\t  CREDENTIAL MANAGE\t\t\t\t|");
            System.out.println("+-----------------------------------------------------------------------+");


            boolean sw = true;

            do{

                System.out.print("\nPlease enter the user name to verify it's you: ");
                String usrName3 = input.next();

                if (usrName1.equals(usrName3)){
                    sw = false;
                    System.out.println("Hey "+usrName1);
                    break;
                }
                else{
                    System.out.println("invalid user name. try again!");
                }
            }while(sw);

            do{
                System.out.print("Enter your current password: ");
                String pwd3 = input.next();

                if(pwd1.equals(pwd3)){
                    sw = true;
                    System.out.print("Enter your new password: ");
                    String newPwd = input.next();

                    pwd1 = newPwd; //password eka assign kala static password ekat

                    System.out.print("\nPassword changed successfully! Do you want to go home page (Y/N): ");
                    String yORn = input.next();

                    if(yORn.equals("y")||yORn.equals("Y")){
                        clearConsole();
                        homePage();
                    }
                }
                else{
                    System.out.println("incorrect password. try again!\n ");
                }

            }while(!sw);


        }

        public static void homePage(){

            System.out.println("+-----------------------------------------------------------------------+");
            System.out.println("|\t\tWELCOME TO IJSE STOCK MANAGEMENT SYSTEM\t\t\t|");
            System.out.println("+-----------------------------------------------------------------------+");

            System.out.println("\n[1] Change the Credentials\t[2] Supplier Manage");
            System.out.println("[3] Stock Manage\t\t[4] Log out");
            System.out.print("[5] Exit the system\n\nEnter an option to continue > ");
            int option = input.nextInt();

            if(option == 1){
                credentialManage();
            }
            if(option == 4){
                clearConsole();
                loginPageAccess();
                homePage();
            }
            if(option == 5){
                clearConsole();
            }
            if(option == 2){
                supplierManage();
            }

            if(option == 3){
                stockManage();
            }
        }

        private final static void clearConsole() {
            final String os = System.getProperty("os.name");
            try {
                if (os.equals("Linux")) {
                    System.out.print("\033\143");
                } else if (os.equals("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                }
            } catch (final Exception e) {
                //handle the exception
                System.err.println(e.getMessage());
            }
        }

        public static void loginPageAccess(){
            System.out.println("+-----------------------------------------------------------------------+");
            System.out.println("|\t\t\t\tLOGIN PAGE\t\t\t\t|");
            System.out.println("+-----------------------------------------------------------------------+");

            boolean sw = true;

            do{

                System.out.println();

                System.out.print("User Name : ");
                String usrName2 = input.next();

                if (usrName1.equals(usrName2)){
                    sw = false;
                    System.out.println();
                    break;
                }
                else{
                    System.out.println("user name is invalid. please try again!");
                }
            }while(sw);

            do{
                System.out.print("Password  : ");
                String pwd2 = input.next();

                if(pwd1.equals(pwd2)){
                    sw = true;
                    break;
                }
                else{
                    System.out.println("password is incorrect. please try again!\n");
                }

            }while(!sw);
            clearConsole();

        }

        public static void main(String args[]){

            loginPageAccess();
            homePage();

        }
}
