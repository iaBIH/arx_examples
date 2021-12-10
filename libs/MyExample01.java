//package arxExamples;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

import org.deidentifier.arx.ARXAnonymizer;
import org.deidentifier.arx.ARXConfiguration;
import org.deidentifier.arx.ARXResult;
import org.deidentifier.arx.AttributeType.Hierarchy;
import org.deidentifier.arx.AttributeType.Hierarchy.DefaultHierarchy;
import org.deidentifier.arx.Data;
import org.deidentifier.arx.Data.DefaultData;
import org.deidentifier.arx.criteria.KAnonymity;

/**
 * This class implements an example on how to use the API by directly providing
 * the input datasets.
 *
 * @author Fabian Prasser
 * @author Florian Kohlmayer
 */

//public class Example01 extends ExampleUtils  {
public class MyExample01   {

    /**
     * Entry point.
     * 
     * @param args
     *            the arguments
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {

        // Define data
        DefaultData data = Data.create();
        data.add("age", "gender", "zipcode");
        data.add("34", "male", "81667");
        data.add("45", "female", "81675");
        data.add("66", "male", "81925");
        data.add("70", "female", "81931");
        data.add("34", "female", "81931");
        data.add("70", "male", "81931");
        data.add("45", "male", "81931");

        // Print data 
        System.out.println(" - Input data:");
        Iterator<String[]> inputDataIterator = data.getHandle().iterator();
        while (inputDataIterator.hasNext()) {
            System.out.print("   ");
            System.out.println(Arrays.toString(inputDataIterator.next()));
        }

        // Define hierarchies
        DefaultHierarchy age = Hierarchy.create();
        age.add("34", "<50", "*");
        age.add("45", "<50", "*");
        age.add("66", ">=50", "*");
        age.add("70", ">=50", "*");

        DefaultHierarchy gender = Hierarchy.create();
        gender.add("male", "*");
        gender.add("female", "*");

        // Only excerpts for readability
        DefaultHierarchy zipcode = Hierarchy.create();
        zipcode.add("81667", "8166*", "816**", "81***", "8****", "*****");
        zipcode.add("81675", "8167*", "816**", "81***", "8****", "*****");
        zipcode.add("81925", "8192*", "819**", "81***", "8****", "*****");
        zipcode.add("81931", "8193*", "819**", "81***", "8****", "*****");

        data.getDefinition().setAttributeType("age", age);
        data.getDefinition().setAttributeType("gender", gender);
        data.getDefinition().setAttributeType("zipcode", zipcode);

        //TODO: access and print definitions  
        
        
        // Create an instance of the anonymizer
        ARXAnonymizer anonymizer = new ARXAnonymizer();
        ARXConfiguration config = ARXConfiguration.create();
        config.addPrivacyModel(new KAnonymity(3));
        config.setSuppressionLimit(0d);

        ARXResult result = anonymizer.anonymize(data, config);

        // Print info, this function can be found in ExamplesUtils.java 
        //printResult(result, data);

        // Print results
        System.out.println(" - Transformed data:");
        Iterator<String[]> transformedDataIterator = result.getOutput(false).iterator();
        while (transformedDataIterator.hasNext()) {
            System.out.print("   ");
            System.out.println(Arrays.toString(transformedDataIterator.next()));
        }//while 
    }//main
}//class   
