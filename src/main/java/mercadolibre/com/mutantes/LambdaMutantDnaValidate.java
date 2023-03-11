package mercadolibre.com.mutantes;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaMutantDnaValidate implements RequestHandler<Dna,String> {

    @Override
    public String handleRequest(Dna dna, Context context) {
        context.getLogger().log("DNA:"+dna);
        DnaValidateUseCase dnaValidateUseCase = new DnaValidateUseCase();
        boolean isMutant = dnaValidateUseCase.isMutant(dna.getDna());
        if(isMutant){
            return "es mutante";
        }else{
            return "es no mutante";
        }
    }
}
