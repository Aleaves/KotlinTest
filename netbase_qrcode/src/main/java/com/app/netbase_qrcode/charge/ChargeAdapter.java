package com.app.netbase_qrcode.charge;

public class ChargeAdapter extends ChinaCharge{

    private USACharge usaCharge;

    public ChargeAdapter(USACharge usaCharge){
        this.usaCharge = usaCharge;
    }


    @Override
    public void chinaCharge() {
        if(usaCharge.usaCharge() == 220){
            System.out.println("符合中国用电标准");
        }else{
            System.out.println("用电异常，电器烧毁");
        }
    }
}
