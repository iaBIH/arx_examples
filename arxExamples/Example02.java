/*
 * ARX: Powerful Data Anonymization
 * Copyright 2012 - 2021 Fabian Prasser and contributors
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package arxExamples;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.deidentifier.arx.ARXAnonymizer;
import org.deidentifier.arx.ARXConfiguration;
import org.deidentifier.arx.ARXResult;
import org.deidentifier.arx.AttributeType.Hierarchy;
import org.deidentifier.arx.Data;
import org.deidentifier.arx.criteria.KAnonymity;

/**
 * This class implements an example on how to use the API.
 * It shows how read/write data from/to csv files 
 *
 * @author Fabian Prasser
 * @author Florian Kohlmayer
 */
public class Example02 extends ExampleUtils {
    
    /**
     * Entry point.
     * 
     * @param args the arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        String inputPath  = "data/test.csv";
        String outputPath = "data/test_result.csv";
        
        System.out.println("Reading data from  "+ inputPath +" ....!!!");
        Data data = Data.create(inputPath, StandardCharsets.UTF_8, ';');
        
        // TODO: simplify the process:
        //   e.g. reading the files from a folder
        //        the files should have standard names: dataFilename_attribute.csv    
        // Define input files for hierarchy
        data.getDefinition().setAttributeType("age"    , Hierarchy.create("data/test_hierarchy_age.csv"    , StandardCharsets.UTF_8, ';'));
        data.getDefinition().setAttributeType("gender" , Hierarchy.create("data/test_hierarchy_gender.csv" , StandardCharsets.UTF_8, ';'));
        data.getDefinition().setAttributeType("zipcode", Hierarchy.create("data/test_hierarchy_zipcode.csv", StandardCharsets.UTF_8, ';'));
        // Create an instance of the anonymizer
        ARXAnonymizer anonymizer = new ARXAnonymizer();
        
        // Execute the algorithm
        ARXConfiguration config = ARXConfiguration.create();
        config.addPrivacyModel(new KAnonymity(2));
        config.setSuppressionLimit(0d);
        ARXResult result = anonymizer.anonymize(data, config);
        
        // Print info
        printResult(result, data);
        
        // Write results
        //TODO: simplify the process by adding a new write function e.g.
        // result.write(path), result.write(path,separator)

        System.out.println(" - Writing data...");
        result.getOutput(false).save(outputPath, ';');        
        System.out.println("Result is saved in "+ outputPath);
        System.out.println("Done!");
    }
}
