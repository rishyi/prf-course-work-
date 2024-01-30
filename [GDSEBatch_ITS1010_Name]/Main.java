
import java.util.*;
public class Main {
    static String iname="admin";
    static String password="1234";
    static int q=0;
    static int x=0;
    static Scanner scanner = new Scanner(System.in);
    static String[][] suppliers = new String[0][2];
    static String[][] sup= new String[0][2];
    static String [] itemCategory=new String [0];
    static String [] [] ItemCode=new String[0] [6];

    public static void main(String []args){

        loginPage();
    }

    public static void loginPage(){
        clearConsole();
        System.out.println("+------------------------+");
        System.out.println("+     Login Page         +");
        System.out.println("+------------------------+");

        boolean one=true;
        boolean two=true;

        do {
            System.out.print("\nUser name : ");
            String name=new Scanner(System.in).nextLine();

            if (name.equals(iname)){
                do {
                    System.out.print("Password : ");
                    String pass=new Scanner(System.in).nextLine();

                    if (pass.equals(password)){
                        one=false;
                        two=false;
                        homePage();
                    }else {
                        System.out.println("Password is incorrect.try again!");
                    }
                }while (two);
            }else {
                System.out.println("User name is invalid.try again! ");
            }
        }while (one);
    }
    public static void homePage(){
        clearConsole();

        System.out.println("+--------------------------------------------------+");
        System.out.println("+      WELCOME TO IJSE STOCK MANAGEMENT SYSTEM     +");
        System.out.println("+--------------------------------------------------+");

        System.out.println("\n [1] Change the Credentials       [2] Supplier Manage ");
        System.out.println(" [3] Stock Manage                 [4] Log out");
        System.out.println(" [5] Eixt the system ");

        boolean one=true;

        do {
            System.out.print("\nEnter an option to continue > ");
            int option=new Scanner(System.in).nextInt();

            if (option==1){
                one=false;
                credential();
            }else if (option==2){
                one=false;
                supplierManage();
            }else if (option==3){
                one=false;
                stockManage();
            }else if (option==4){
                one=false;
                loginPage();
            }else if (option==5){
                one=false;
                exit();
            }else {
                System.out.println("invalid input! ");
            }
        }while (one);
    }
    public static void credential(){
        clearConsole();
        System.out.println("+-------------------------------+");
        System.out.println("+        Credential Manage      +");
        System.out.println("+-------------------------------+");

        boolean one=true;
        boolean two=true;

        do {
            System.out.print("\nPlease enter the user name to verify it's you : ");
            String name=new Scanner(System.in).nextLine();


            if (name.equals(iname)){
                System.out.println("hey "+name);
                do {
                    System.out.print("Enter your current password : ");
                    String pass=new Scanner(System.in).nextLine();

                    if (pass.equals(password)){
                        one=false;
                        two=false;

                        System.out.print("Enter your new password : ");
                        String newPass=new Scanner(System.in).nextLine();

                        password=newPass;

                        System.out.print("Password changed successfully! Do you want to go home page (Y/N) : ");
                        String goo=new Scanner(System.in).nextLine();

                        String x="Y";
                        String y="N";

                        if(goo.equals(x)){
                            homePage();
                        }if (goo.equals(y)){
                            System.out.println("Good bye! see you next time ");
                        }
                    }else {
                        System.out.println("Incorrect password.Try again!");
                    }
                }while (two);
            }else {
                System.out.println("Invalid user name.Try again!");
            }
        }while (one);
    }
    public static void supplierManage(){

        clearConsole();
        System.out.println("+--------------------------------------------------+");
        System.out.println("+                  SUPPLIER  MANAGE                +");
        System.out.println("+--------------------------------------------------+");

        System.out.println("\n[1] Add Supplier                  [2] Update Supplier  ");
        System.out.println("[3] Delete Supplier               [4] View Suppliers ");
        System.out.println("[5] Search Supplier               [6] Home Page  ");

        System.out.print("Enter an option to continue > ");
        int option=new Scanner(System.in).nextInt();
        boolean one=false;

        do {
            switch (option){

                case 1:
                    clearConsole();
                    addSupplier();
                    break;
                case 2:
                    updateSupplier();
                    break;
                case 3:
                    deleteSupplier();
                    break;
                case 4:
                    viewSupplier();
                    break;
                case 5:
                    serchSupplier();
                    break;
                case 6:
                    supplierManageGoHome();
                    break;
                default:
                    System.out.println("Invalid input.try again ");
                    break;
            }
        }while (one);
    }
    public static void addSupplier(){

        clearConsole();
        System.out.println("+--------------------------------+");
        System.out.println("+         ADD SUPPLIER           +");
        System.out.println("+--------------------------------+");

        boolean three =false;
        boolean two = false;

        do {
            System.out.print("\nSupplier ID : ");
            String supId = new Scanner(System.in).next();

            boolean one =checkSuId(supId);

            if (one){
                three =false;
                System.out.print("Supplier Name : ");
                String supName = new Scanner(System.in).next();

                sup = growSupArr(supId,supName);
                System.out.print("\nadded successfully!");
            }
            else{
                System.out.println("already exists.try another supplier id!");
                three = true;
            }
        }while (three);
        do {

            System.out.print("Do you want to add another supplier (Y/N)? ");
            String option=new Scanner(System.in).next();

            if (option.equals("Y")){
                addSupplier();
            }
            if (option.equals("N")){
                supplierManage();
            }else {
                System.out.println("invalid inpiut.try again");
                two=true;
            }
        }while (two);
    }
    private static String[][] growSupArr(String supId,String supName){
        String[][] temp= new String[sup.length+1][2];
        for (int i = 0; i < sup.length; i++) {
            for (int j = 0; j < sup[i].length; j++) {
                temp[i][j]= sup[i][j];
            }
        }
        temp[temp.length-1][0]= supId;
        temp[temp.length-1][1]=supName;

        return temp;
    }
    public static boolean checkSuId(String supId){

        for (int i = 0; i < sup.length; i++) {
            if (sup[i][0].equals(supId)){
                return false;
            }
        }
        return true;
    }
    public static void updateSupplier(){

        clearConsole();
        System.out.println("+--------------------------------------+");
        System.out.println("+             Update Supplier          +");
        System.out.println("+--------------------------------------+");

        String sID = "0";
        String sName = "0";
        String NewsName = "0";

        boolean while_02 = true;
        do{
            System.out.print("Enter ID :");
            sID = scanner.nextLine();

            boolean rem = checkUpdateID(sID, sup);

            if(rem){
                System.out.print("Enter name : ");
                sName = scanner.nextLine();

                System.out.print("Enter new name :");
                NewsName = scanner.nextLine();

                sup[x-1][1]=NewsName;
                while_02=false;
            }else {
                System.out.println("can't find supplier id. try again!");
            }
        }while(while_02);

        boolean while_01=false;

        do{
            System.out.print("Updated Successfully! Do you want to update another supplier(y/n)? ");
            String num= scanner.nextLine();

            if(num.equals("Y")){
                updateSupplier();
            }
            if(num.equals("N")){
                supplierManage();
            }else{
                System.out.println("Wrong Commond. Plese Try Agin !");
                while_01 = true;
            }
        }while(while_01);
    }
    public static String[][] DeletingSuppier(String[][] arr) {

        String[][] temp = new String[arr.length-1][2];

        for (int i = 0; i < arr.length-1; i++) {

            if (arr[i][0] != "Delete") {
                temp[q][0] = arr[i][0];
                temp[q][1] = arr[i][1];
                q++;
            }
        }
        return temp;
    }
    public static boolean checkID(String ID, String[][] arr) {
        x=0;
        boolean flag = false;
        for (int i = 0; i < arr.length-1; i++) {
            x++;
            if (arr[i][0].equals(ID)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    public static boolean checkUpdateID(String ID,String[][] arr){

        boolean rem= false;

        for(int i=0;i<arr.length;i++){
            x++;
            if(arr[i][0].equals(ID)){
                rem =true;
                break;
            }
        }
        return rem;
    }
    public static void  deleteSupplier(){
        clearConsole();
        System.out.println("+---------------------------------------------------------+");
        System.out.println("+                    Delete Supplier                      +");
        System.out.println("+---------------------------------------------------------+");


        String sID = "0";

        boolean flag = true;
        do {
            System.out.print("Enter delete ID : ");
            sID = scanner.nextLine();

            boolean isIDValid = checkID(sID, sup);

            if (isIDValid) {
                sup[x - 1][0] = "Delete";
                sup[x - 1][1] = "Delete";

                sup = DeletingSuppier(sup);
                flag = false;
            } else {
                System.out.println("Wrong ID entered.");
            }
        } while (flag);


        boolean while_01 = false;

        do{
            System.out.print("Deleted successfully! Do you want to delete another(y/n)? ");
            String num = scanner.nextLine();

            if(num.equals("Y")){
                deleteSupplier();
            }
            if(num.equals("N")){
                supplierManage();
            }else{
                System.out.println("Wrong Command. Plese Try Agin !");
                while_01 = true;
            }
        }while(while_01);


    }
    public static void viewSupplier(){

        clearConsole();
        System.out.println("+-------------------------------------------------------+");
        System.out.println("+                   VIEW SUPPLIERS                      +");
        System.out.println("+-------------------------------------------------------+");

        System.out.println("+--------------------------------------+");
        System.out.println("| Supplier ID  |     Supplier Name     |");
        System.out.println("+--------------------------------------+");

        for (String[] strings : sup){
            System.out.printf("|   %-10s |      %-16s |%n", strings[0], strings[1]);
        }
        System.out.println("+--------------------------------------+");

        boolean one=true;
        do {
            System.out.print("Do you want to go supplier manage page(Y/N)?");
            String go=scanner.nextLine();

            if (go.equals("Y")){
                supplierManage();
            }if(go.equals("N")) {
                homePage();
            }else {
                System.out.println("Invalid input.do you want to go Supplier mange page(Y) or Go home page(Y).");
            }
        }while (one);
    }
    public static void serchSupplier(){
        clearConsole();
        System.out.println("+------------------------------------------------+");
        System.out.println("+                SEARCH SUPPLIER                 +");
        System.out.println("+------------------------------------------------+");
        while(true){
            System.out.print("Supplier Id :\t");
            String x=scanner.next();
            for(int i=0;i<suppliers.length;i++){
                for(int j=0;j<suppliers[i].length;j++){
                    if(x.equals(suppliers[i][0])){
                        System.out.println("Supplier Name :"+suppliers[i][j]);
                        System.out.print("added SuccessFully ! Do\b\byou want to find another ?(Y?N) ");
                        char option = scanner.next().charAt(0);
                        if(option=='Y'||option=='y'){
                            clearConsole();

                            break;
                        }else if (option=='N'||option=='n'){
                            clearConsole();
                            supplierManage();
                            System.exit(0);
                        }

                    }
                }
            }System.out.println("Can't find supplier Id.try again!");
        }
    }
    public static void supplierManageGoHome(){
        homePage();
    }
    public static void stockManage(){
        clearConsole();
        System.out.println("+---------------------------------------------------------+");
        System.out.println("+                      STOCK MANAGEMENT                   +");
        System.out.println("+---------------------------------------------------------+");
        System.out.println("\n[1] Manage Item Categories             [2] Add Item");
        System.out.println("[3] Get Item Supplier Wise             [4] View Item");
        System.out.println("[5] Rank Item Price Per Unit           [6] Home Page");

        boolean one=true;

        do {
            System.out.print("\nEnter an option to continue > ");
            int option=new Scanner(System.in).nextInt();

            if (option==1){
                one=false;
                manageItemCategories();
            }else if (option==2){
                one=false;
                addItem();
            }else if (option==3){
                one=false;
                getItemSupplierWise();
            }else if (option==4){
                one=false;
                viewItem();
            }else if (option==5){
                one=false;
                rankItemPricePerUnit();
            } else if (option==6) {
                one=false;
                homePage();
            } else{
                System.out.println("invalid input! ");
            }
        }while (one);
    }

    public static void manageItemCategories(){
            clearConsole();
        System.out.println("+---------------------------------------------------+");
        System.out.println("+               MANAGE ITEM CATEGORY                +");
        System.out.println("+---------------------------------------------------+");

        System.out.println("\n[1] Add New Item Category                   [2] Delete Item Category ");
        System.out.println("[3] Update Item Category                    [4] Stock Management ");

        boolean one=true;

        do {
            System.out.print("\nEnter an option to continue > ");
            int option=scanner.nextInt();

            if (option==1){
                one=false;
                addNewItemCategory();
            } else if (option==2) {
                one=false;
                deleteItemCategory();
            } else if (option==3) {
                one=false;
                updateItemCategory();
            } else if (option==4) {
                one=false;
                goStockManage();
            }else {
                System.out.println("invalid input try again!");
            }
        }while(one);
    }
    public static void addNewItemCategory(){
        clearConsole();
        System.out.println("+-----------------------------------------------------------------+");
        System.out.println("+                    ADD ITEM CATEGORY                            +");
        System.out.println("+-----------------------------------------------------------------+");


        while(true){
            boolean flag = false;

            System.out.print("Enter the new Item Category: ");
            String itemCatName = scanner.next();

            for (int i = 0; i < itemCategory.length; i++){
                if(itemCatName.equals(itemCategory[i])){
                    flag = true;
                    break;
                }
            }

            if(flag == false){
                growItemCategory();

                itemCategory[itemCategory.length-1] = itemCatName;
                System.out.print("added successfully! Do you want to add another category(Y/N)? ");


                char x= scanner.next().charAt(0);;
                if(x=='y'||x=='n'){
                    clearConsole();
                    addNewItemCategory();

                }else {
                    clearConsole();
                    manageItemCategories();
                    System.exit(0);
                }

            }
        }
    }
    public static void growItemCategory(){
        String [] xr = new String [itemCategory.length + 1];
        for (int i = 0; i < itemCategory.length; i++) {
            xr[i]=itemCategory[i];
        }
        itemCategory=xr;
    }
    public static void deleteItemCategory(){
        clearConsole();
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("+                       DELETE ITEM CATEGORY                          +");
        System.out.println("+---------------------------------------------------------------------+");
        while(true){
            System.out.print("Item Category: :\t");
            String x=scanner.next();
            for(int i=0;i<itemCategory.length;i++){
                if(x.equals(itemCategory[i])){
                    System.out.print("Deleted SuccessFully ! Do\b\byou want to delete another ?(Y?N) ");
                    char option = scanner.next().charAt(0);
                    if(option=='Y'||option=='y'){
                        clearConsole();
                        deleteItemCategory();
                        break;
                    }else if (option=='N'||option=='n'){
                        clearConsole();
                        manageItemCategories();
                        System.exit(0);
                    }

                }
            }System.out.println("Can't find Item Category:.try again!");
        }
    }
    public static void updateItemCategory(){
        clearConsole();
        System.out.println("+-------------------------------------------------------------------+");
        System.out.println("+                  UPDATE ITEM CATEGORY                             +");
        System.out.println("+-------------------------------------------------------------------+");
        while(true){
            System.out.print("Enter the Item Category :");
            String itemCatName =scanner.next();
            for (int i=0;i<itemCategory.length;i++){
                if (itemCategory[i].equals(itemCatName)){

                    // System.out.print("item  Category :"+itemCatName);
                    System.out.println("\nCurrentitem Cat Name: " + suppliers[i]);
                    System.out.print("\nEnter new item Cat Name: ");
                    String newitemCatName = scanner.next();
                    itemCategory[i] = newitemCatName;
                    System.out.println();
                    System.out.print("Update successdully ! Do you want to update another item? (Y/N): ");
                    char option = scanner.next().charAt(0);

                    if(option=='Y'||option=='y'){
                        clearConsole();
                        updateItemCategory();
                        return;
                    }
                    else if (option=='N'||option=='n'){

                        clearConsole();
                        manageItemCategories();
                    }
                }
            } System.out.println("can't find item name . Try again!");
        }
    }
    public static void goStockManage(){
        stockManage();
    }
    public static void addItem(){
        clearConsole();
        System.out.println("+-----------------------------------------------------+");
        System.out.println("+                    ADD ITEM                         +");
        System.out.println("+-----------------------------------------------------+");
        while(true){
            if(itemCategory.length == 0){
                System.out.println("OOPS! It seems that don't have any item categories in the system.");
                System.out.print("Do you want to add a new item category?(Y/N) : ");

                char ch = scanner.next().charAt(0);
                if(ch == 'n' || ch == 'N'){
                    homePage();
                    return;
                }else if(ch == 'y' || ch == 'Y'){
                    clearConsole();
                    addNewItemCategory();
                    return;
                }
            }else if(suppliers.length == 0){
                System.out.println("OOPS! It seems that don't have any supplier in the system.");
                System.out.print("Do you want to add a new supplier?(Y/N) : ");

                char ch = scanner.next().charAt(0);
                if(ch == 'n' || ch == 'N'){
                    homePage();
                    return;
                }else if(ch == 'y' || ch == 'Y'){
                    clearConsole();
                    addSupplier();
                    return;
                }
            }else{
                growItemCode();

                while(true){
                    boolean one = false;

                    System.out.print("Item Code : ");
                    String itemCode=scanner.next();

                    for (int i = 0; i < ItemCode.length; i++){
                        if(itemCode.equals(ItemCode[i][0])){
                            System.out.println("Item Code already exists! Enter Item Code again");
                        }
                    }

                    if(one == false){
                        ItemCode[ItemCode.length-1][0] =itemCode;
                        break;
                    }
                }

                System.out.println();
                System.out.println("Suppliers list : ");

                System.out.printf("+------------------+-------------------+-------------------+%n");
                System.out.printf("|     %s      |    %s    |   %s   |%n","   #   ","SUPPLIER ID","SUPPLIER NAME");
                System.out.printf("+------------------+-------------------+-------------------+%n");

                for (int i = 0; i < suppliers.length; i++){
                    System.out.printf("|    %-10s    |     %-10s    |    %-10s     |%n",(i+1),suppliers[i][0],suppliers[i][1]);
                }
                System.out.printf("+------------------+-------------------+-------------------+%n");

                while(true){
                    System.out.println();
                    System.out.print("Enter the supplier number > ");

                    int supNum = scanner.nextInt();

                    if(supNum > suppliers.length || supNum <= 0){
                        System.out.print("Invalid number! Enter again");
                    }else{
                        ItemCode[ItemCode.length-1][1] = suppliers[supNum-1][0];
                        break;
                    }
                }

                System.out.println();
                System.out.println("Item Categories : ");

                System.out.printf("+------------------+-------------------+%n");
                System.out.printf("|     %s      |   %s   |%n","   #   ","CATEGORY NAME");
                System.out.printf("+------------------+-------------------+%n");

                for (int i = 0; i < itemCategory.length; i++){
                    System.out.printf("|    %-10s    |     %-10s    |%n",(i+1),itemCategory[i]);
                }
                System.out.printf("+------------------+-------------------+%n");

                while(true){
                    System.out.println();
                    System.out.print("Enter the category number : ");
                    int catNum = scanner.nextInt();

                    if(catNum > itemCategory.length || catNum <= 0){
                        System.out.print("Invalid number.! Enter again..");
                    }else{
                        ItemCode[ItemCode.length-1][2] = itemCategory[catNum-1];
                        break;
                    }
                }

                System.out.println();
                System.out.print("Description : ");
                String description = scanner.next();

                ItemCode[ItemCode.length-1][3] = description;

                while(true){
                    System.out.println();
                    System.out.print("Unit price : ");
                    String price = scanner.next();

                    if(Double.parseDouble(price)>0){
                        ItemCode[ItemCode.length-1][4] = price;
                        break;
                    }else{
                        System.out.print("Invalid Unit price enter again..\n");
                    }
                }

                while(true){
                    System.out.println();
                    System.out.print("Qty on hand : ");
                    String qty=scanner.next();

                    if(Integer.parseInt(qty)>0){
                        ItemCode[ItemCode.length-1][5] = qty;
                        break;
                    }else{
                        System.out.print("Invalid Unit price enter again..\n");
                    }
                }

                System.out.print("added successfully! Do you want to add another Item(Y/N)? ");
                char ch = scanner.next().charAt(0);
                if(ch == 'n' || ch == 'N'){
                    clearConsole();
                    stockManage();
                    System.exit(0);
                }else if(ch == 'y' || ch == 'Y'){
                    clearConsole();
                    addItem();

                }
            }
        }
    }
    public static void growItemCode(){
        String [][] temp=new String [ItemCode.length+1][6];
        for (int i =0; i<ItemCode.length;i++){
            temp[i]=ItemCode[i];
        }
        ItemCode=temp;
    }
    public static void getItemSupplierWise(){
        clearConsole();
        System.out.println("+--------------------------------------------------------------------------------+");
        System.out.println("+                          GET ITEM SUPPLIER WISE                                +");
        System.out.println("+--------------------------------------------------------------------------------+");
        while (true){
            System.out.print("Enter\t the Supplier Id : ");
            String supId=scanner.next();
            for (int i=0;i<suppliers.length;i++){
                if (supId.equals(suppliers[i][0])){
                    System.out.println("Supplier Name :"+ suppliers[i][1]+"\n\n");
                    System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");
                    System.out.printf("|     %s    |    %s    |     %s    |     %s   |     %s      |%n","ITEM CODE","DESCRIPTION","UNIT PRICE","QTY ON HAND","CATEGORY");
                    System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");


                    for (int j = 0; j < ItemCode.length; j++){
                        if(supId.equals(ItemCode[j][1])){
                            System.out.printf("|    %10s    |    %-10s    |    %10s      |    %10s    |    %10s     |%n",ItemCode[j][0],ItemCode[j][3],ItemCode[j][4],ItemCode[j][5],ItemCode[j][2]);

                        }
                    }System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");

                    System.out.print("search successfully! Do you want to another search?(Y/N) ");
                    char ch = scanner.next().charAt(0);
                    if(ch == 'n' || ch == 'N'){
                        clearConsole();
                        stockManage();
                        System.exit(0);
                    }else if(ch == 'y' || ch == 'Y'){
                        clearConsole();
                        getItemSupplierWise();
                    }
                }
            }System.out.print("can't find supplier id.try again !\n");
        }
    }
    public static void viewItem(){
        System.out.println("+----------------------------------------------------------+");
        System.out.println("+                       VIEW ITEM                          +");
        System.out.println("+----------------------------------------------------------+");
        for (int i = 0; i < itemCategory.length; i++){
            System.out.println("\n"+itemCategory[i]+":");
            System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");
            System.out.printf("|        %s       |        %s       |        %s       |        %s      |        %s        |%n","SID","CODE","DESC","PRICE","QTY");
            System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");
            for (int j = 0; j < ItemCode.length; j++){
                if(ItemCode[j][2].equals(itemCategory[i])){
                    System.out.printf("|    %10s    |    %10s     |    %10s     |    %10s     |    %10s     |%n",ItemCode[j][1],ItemCode[j][0],ItemCode[j][3],ItemCode[j][4],ItemCode[j][5]);
                }
            }
            System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");
        }
        System.out.print("Do you want to go stock manage page?(Y/N)  ");

        char ch = scanner.next().charAt(0);
        if(ch == 'n' || ch == 'N'){
            exit();
        }else if(ch == 'y' || ch == 'Y'){
            stockManage();
            System.exit(0);
        }
    }
    public static void rankItemPricePerUnit(){
        System.out.println("+---------------------------------------------------+");
        System.out.println("+                  RANK ITEM                        +");
        System.out.println("+---------------------------------------------------+");

        String [][] sortedArray = new String[ItemCode.length][6];

        for (int i = 0; i < ItemCode.length; i++){
            sortedArray[i] = ItemCode[i];
        }

        for (int i = 0; i < ItemCode.length; i++){
            for (int j = 0; j < ItemCode.length-1; j++){
                if(Double.parseDouble(sortedArray[j][4])>Double.parseDouble(sortedArray[j+1][4])){
                    String [] temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j+1];
                    sortedArray[j+1] = temp;
                }

            }
        }

        System.out.println();
        System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+-------------------+%n");
        System.out.printf("|        %s       |        %s       |        %s       |        %s      |        %s        |        %s        |%n","SID","CODE","DESC","PRICE","QTY","CAT");
        System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+-------------------+%n");

        for (int i = 0; i < sortedArray.length; i++){
            System.out.printf("|    %10s    |    %10s     |    %10s     |    %10s     |    %10s     |    %10s     |%n",sortedArray[i][1],sortedArray[i][0],sortedArray[i][3],Double.parseDouble(sortedArray[i][4]),sortedArray[i][5],sortedArray[i][2]);
        }
        System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+-------------------+%n");
        System.out.print("Do you want to go stock manage page?(Y/N)  ");

        char ch = scanner.next().charAt(0);
        if(ch == 'n' || ch == 'N'){
            exit();
        }else if(ch == 'y' || ch == 'Y'){
            stockManage();
            System.exit(0);
        }
    }
    public static void stockManageGoHomePage(){

        homePage();
    }
    public static void logOut(){
        System.out.print("Do you want to log out ! (Y/N):  ");
        char x= scanner.next().charAt(0);;
        if(x=='Y'){
            clearConsole();
            loginPage();
        }else if (x=='N') {
            clearConsole();
            homePage();
        }
    }
    public static void exit(){
        clearConsole();
        System.exit(0);
    }
    public static void clearConsole() {
        try {
            // For Windows
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

