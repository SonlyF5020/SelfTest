import java.util.List;

public class GenericChooser implements Chooser {

    @Override
    public Parkable choseParkable(List<Parkable> parkables) {
        Parkable target = null;

        for (Parkable parkable : parkables){
            if (parkable.isAvaiable()){
                target = parkable;
                break;
            }
        }
        return target;
    }
}
