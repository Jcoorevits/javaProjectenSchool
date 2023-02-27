package fact.it.refuelling.model;

import java.sql.Ref;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RefuellingService {
    List<Refuelling> refuellingList = new ArrayList<>();

    public RefuellingService() {
        refuellingList.add(new Refuelling(1, 400, 900, 30));
        refuellingList.add(new Refuelling(2, 1000, 1987, 52.0));
        refuellingList.add(new Refuelling(3, 1000, 1200, 14.1));
    }

    public Optional<Refuelling> getOptionalRefuellingById(int refuelId) {
        return getRefuellingList().stream().filter(p -> p.getId() == refuelId).findFirst();
    }

    public List<Refuelling> getRefuellingList() {
        return refuellingList;
    }

    public void setRefuellingList(List<Refuelling> refuellingList) {
        this.refuellingList = refuellingList;
    }

    public Refuelling addRefuelling(Refuelling newRefuelling) {
        newRefuelling.setId(refuellingList.size() + 1);
        refuellingList.add(newRefuelling);
        return refuellingList.get(refuellingList.size() - 1);
    }

    public Refuelling updateRefuellingById(Refuelling updateRefuelling, int refuellingid) {
        Optional<Refuelling> refuellingOptional = getOptionalRefuellingById(refuellingid);
        if (refuellingOptional.isPresent()) {
            Refuelling refuelling = refuellingOptional.get();
            refuelling.setPreviousMileage(updateRefuelling.getPreviousMileage());
            refuelling.setCurrentMileage(updateRefuelling.getCurrentMileage());
            refuelling.setAmountInLitres(updateRefuelling.getAmountInLitres());
            return refuelling;
        }
        return null;
    }

    public double getTotalConsumption() {
        double sum = 0;

//        for (int i = 0; i < refuellingList.size(); i++){
//            sum += refuellingList.get(i).getAmountInLitres();
//        }

        for (Refuelling refuelling : refuellingList) {
            sum += refuelling.getFuelConsumption();
        }
        return sum;
    }

}
