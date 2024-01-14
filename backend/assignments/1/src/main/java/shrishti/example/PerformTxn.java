package shrishti.example;

import java.util.Objects;
import shrishti.example.Logger.logger;
public class PerformTxn implements Runnable{

    private Parse txn;
    public PerformTxn(Parse txn){
        this.txn = txn;
    }
    @Override
    public void run(){
        Transaction.Type type = null;
        logger.printMessage(txn.toString());
        if(Objects.equals(txn.getType(), "BUY")){
            type = Transaction.Type.BUY;
            Transaction executeTransaction = new Transaction(txn.getCoinData(), type);
            try{
                executeTransaction.buy();
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
        else if(Objects.equals(txn.getType(), "SELL")){
            type = Transaction.Type.SELL;
            Transaction executeTransaction = new Transaction(txn.getCoinData(), type);
            try{
                executeTransaction.sell();
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
        else if(Objects.equals(txn.getType(), "UPDATEPRICE")){
            type = Transaction.Type.UPDATEPRICE;
            Transaction executeTransaction= new Transaction(txn.getCoinData(), type);
            executeTransaction.update();
        }
        else if(Objects.equals(txn.getType(), "ADDVOLUME")){
            type = Transaction.Type.ADDVOLUME;
            Transaction executeTransaction = new Transaction(txn.getCoinData(), type);
            executeTransaction.add();
        }
    }
}
