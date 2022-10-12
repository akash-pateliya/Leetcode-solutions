class Solution {
    class Change{
        int five;
        int ten;
        int twenty;
        
        Change(){
            this.five = 0;
            this.ten = 0;
            this.twenty = 0;
        }
    }
    public boolean lemonadeChange(int[] bills) {
        Change change = new Change();
        
        for(int bill: bills){
            switch(bill){
                case 5: change.five += 1;
                    break;
                case 10: change.ten += 1;
                    break;
                case 20: change.twenty += 1;
                    break;
            }
            
            if(!haveChange(bill, change)){
                return false;
            }
        }
        
        return true;
    }
    
    boolean haveChange(int bill,Change change){
        int returnAmount = bill - 5;
        int five=change.five, ten=change.ten, twenty = change.twenty;
        
        while(twenty > 0 && returnAmount >= 20){
            returnAmount -= 20;
            twenty--;
        }
        while(ten > 0 && returnAmount >= 10){
            returnAmount -= 10;
            ten--;
        }
        while(five > 0 && returnAmount >= 5){
            returnAmount -= 5;
            five--;
        }
        
        change.five = five;
        change.ten = ten;
        change.twenty= twenty;
        
        return returnAmount == 0;
    }
}