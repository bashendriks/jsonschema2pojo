/**
 * Copyright © 2010-2020 Nokia
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nl.basch.jsonschema2pojo.example;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

import nl.basch.jsonschema2pojo.DefaultGenerationConfig;
import nl.basch.jsonschema2pojo.GenerationConfig;
import nl.basch.jsonschema2pojo.Jackson2Annotator;
import nl.basch.jsonschema2pojo.SchemaGenerator;
import nl.basch.jsonschema2pojo.SchemaMapper;
import nl.basch.jsonschema2pojo.SchemaStore;
import nl.basch.jsonschema2pojo.rules.RuleFactory;

import com.sun.codemodel.JCodeModel;

public class Example {

    public static void main(String[] args) throws IOException {

        // BEGIN EXAMPLE

        JCodeModel codeModel = new JCodeModel();

        URL source = Example.class.getResource("/schema/required.json");

        GenerationConfig config = new DefaultGenerationConfig() {
            @Override
            public boolean isGenerateBuilders() { // set config option by overriding method
                return true;
            }
        };

        SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
        mapper.generate(codeModel, "ClassName", "com.example", source);

        codeModel.build(Files.createTempDirectory("required").toFile());

        // END EXAMPLE

    }

}
