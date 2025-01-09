class Solution {
    public int strongPasswordChecker(String password) {
        int a = 0, b = 0, c = 0, e = 0, d = 1,f=0;
        boolean lower=false,upper=false,digit=false;
        int length = password.length();
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (length < 6 || length > 20) {
            if (length - 6 < 0) {
                a = a + (6 - password.length());
                return a;
            }
            if (length - 20 > 0) {
                a = a + (password.length() - 20);
                f=a;
            }
        }
        for(int i =1;i<length;i++){
            if(Character.isLowerCase(password.charAt(i))){lower=true;}
            if(Character.isUpperCase(password.charAt(i))){upper=true;}
            if(Character.isDigit(password.charAt(i))){digit=true;}
            if(password.charAt(i)==password.charAt(i-1)){
                d++;                                 
            }
            else{
                if(d>2){arrayList.add(d);}
                d=1;
            }
            if(i==length-1){
                if(d>2){arrayList.add(d);}
                d=1;
            }
        }
        if(!lower){b++;}
        if(!upper){b++;}
        if(!digit){b++;}
        int j=0;
        while(f!=0&&arrayList.size()!=0){
            if(j==arrayList.size()){
                j=0;
            }
            if(arrayList.get(j)>2){
                arrayList.set(j,arrayList.get(j)-1);
                f--;
                j++;
            }            
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) >= 3) {
                c = c+arrayList.get(i) / 3;
            }
        }
        if (a == 0 && c != 0) {
            return b > c ? b : c;
        } else if (a != 0 && c != 0) {
            return a + (b > c ? b : c);
        } else {
            return b + a;
        }
    }
}