package com.javaparsers.controller;

import com.fasterxml.jackson.databind.module.SimpleModule;
import io.swagger.parser.OpenAPIParser;
import io.swagger.util.Json;
//import io.swagger.oas.inflector.examples.ExampleBuilder;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.examples.Example;
import io.swagger.v3.oas.models.media.ComposedSchema;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.ObjectSchema;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.ParseOptions;
import io.swagger.v3.parser.core.models.SwaggerParseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import io.swagger.inflector.processors.JsonNodeExampleSerializer;

import java.util.ArrayList;
import java.util.Map;


public class ParserController
{

public static void main (String []args) {

    ParseOptions options = new ParseOptions();
    options.setResolveFully(true);
    options.setResolveCombinators(false);
//    OpenAPI openAPI = new OpenAPIV3Parser().readLocation("/Users/I322308/Desktop/test.json",null,options).getOpenAPI();

OpenAPI openAPI = new OpenAPIV3Parser().readContents("{\n" +
        "  \"openapi\": \"3.0.2\",\n" +
        "  \"info\": {\n" +
        "    \"title\": \"Swagger Petstore - OpenAPI 3.0\",\n" +
        "    \"description\": \"This is a sample Pet Store Server based on the OpenAPI 3.0 specification.  You can find out more about\\nSwagger at [http://swagger.io](http://swagger.io). In the third iteration of the pet store, we've switched to the design first approach!\\nYou can now help us improve the API whether it's by making changes to the definition itself or to the code.\\nThat way, with time, we can improve the API in general, and expose some of the new features in OAS3.\\n\\nSome useful links:\\n- [The Pet Store repository](https://github.com/swagger-api/swagger-petstore)\\n- [The source API definition for the Pet Store](https://github.com/swagger-api/swagger-petstore/blob/master/src/main/resources/openapi.yaml)\",\n" +
        "    \"termsOfService\": \"http://swagger.io/terms/\",\n" +
        "    \"contact\": { \"email\": \"apiteam@swagger.io\" },\n" +
        "    \"license\": {\n" +
        "      \"name\": \"Apache 2.0\",\n" +
        "      \"url\": \"http://www.apache.org/licenses/LICENSE-2.0.html\"\n" +
        "    },\n" +
        "    \"version\": \"1.0.17\"\n" +
        "  },\n" +
        "  \"externalDocs\": {\n" +
        "    \"description\": \"Find out more about Swagger\",\n" +
        "    \"url\": \"http://swagger.io\"\n" +
        "  },\n" +
        "  \"servers\": [{ \"url\": \"/api/v3\" }],\n" +
        "  \"tags\": [\n" +
        "    {\n" +
        "      \"name\": \"pet\",\n" +
        "      \"description\": \"Everything about your Pets\",\n" +
        "      \"externalDocs\": {\n" +
        "        \"description\": \"Find out more\",\n" +
        "        \"url\": \"http://swagger.io\"\n" +
        "      }\n" +
        "    },\n" +
        "    {\n" +
        "      \"name\": \"store\",\n" +
        "      \"description\": \"Access to Petstore orders\",\n" +
        "      \"externalDocs\": {\n" +
        "        \"description\": \"Find out more about our store\",\n" +
        "        \"url\": \"http://swagger.io\"\n" +
        "      }\n" +
        "    },\n" +
        "    { \"name\": \"user\", \"description\": \"Operations about user\" }\n" +
        "  ],\n" +
        "  \"paths\": {\n" +
        "    \"/pet\": {\n" +
        "      \"post\": {\n" +
        "        \"tags\": [\"pet\"],\n" +
        "        \"summary\": \"Add a new pet to the store\",\n" +
        "        \"description\": \"Add a new pet to the store\",\n" +
        "        \"operationId\": \"addPet\",\n" +
        "        \"requestBody\": {\n" +
        "          \"description\": \"Create a new pet in the store\",\n" +
        "          \"content\": {\n" +
        "            \"application/json\": {\n" +
        "              \"schema\": { \"$ref\": \"#/components/schemas/Pet\" }\n" +
        "            },\n" +
        "            \"application/xml\": {\n" +
        "              \"schema\": { \"$ref\": \"#/components/schemas/Pet\" }\n" +
        "            },\n" +
        "            \"application/x-www-form-urlencoded\": {\n" +
        "              \"schema\": { \"$ref\": \"#/components/schemas/Pet\" }\n" +
        "            }\n" +
        "          },\n" +
        "          \"required\": true\n" +
        "        },\n" +
        "        \"responses\": {\n" +
        "          \"200\": {\n" +
        "            \"description\": \"Successful operation\",\n" +
        "            \"content\": {\n" +
        "              \"application/xml\": {\n" +
        "                \"schema\": { \"$ref\": \"#/components/schemas/Pet\" }\n" +
        "              },\n" +
        "              \"application/json\": {\n" +
        "                \"schema\": { \"$ref\": \"#/components/schemas/Pet\" }\n" +
        "              }\n" +
        "            }\n" +
        "          },\n" +
        "          \"405\": { \"description\": \"Invalid input\" }\n" +
        "        },\n" +
        "        \"security\": [{ \"petstore_auth\": [\"write:pets\", \"read:pets\"] }]\n" +
        "      }\n" +
        "    },\n" +
        "    \"/pet/{petId}\": {\n" +
        "      \"get\": {\n" +
        "        \"tags\": [\"pet\"],\n" +
        "        \"summary\": \"Find pet by ID\",\n" +
        "        \"description\": \"Returns a single pet\",\n" +
        "        \"operationId\": \"getPetById\",\n" +
        "        \"parameters\": [\n" +
        "          {\n" +
        "            \"name\": \"petId\",\n" +
        "            \"in\": \"path\",\n" +
        "            \"description\": \"ID of pet to return\",\n" +
        "            \"required\": true,\n" +
        "            \"schema\": { \"type\": \"integer\", \"format\": \"int64\" }\n" +
        "          }\n" +
        "        ],\n" +
        "        \"responses\": {\n" +
        "          \"200\": {\n" +
        "            \"description\": \"successful operation\",\n" +
        "            \"content\": {\n" +
        "              \"application/xml\": {\n" +
        "                \"schema\": { \"$ref\": \"#/components/schemas/Pet\" }\n" +
        "              },\n" +
        "              \"application/json\": {\n" +
        "                \"schema\": { \"$ref\": \"#/components/schemas/Pet\" }\n" +
        "              }\n" +
        "            }\n" +
        "          },\n" +
        "          \"400\": { \"description\": \"Invalid ID supplied\" },\n" +
        "          \"404\": { \"description\": \"Pet not found\" }\n" +
        "        },\n" +
        "        \"security\": [\n" +
        "          { \"api_key\": [] },\n" +
        "          { \"petstore_auth\": [\"write:pets\", \"read:pets\"] }\n" +
        "        ]\n" +
        "      },\n" +
        "      \"post\": {\n" +
        "        \"tags\": [\"pet\"],\n" +
        "        \"summary\": \"Updates a pet in the store with form data\",\n" +
        "        \"description\": \"\",\n" +
        "        \"operationId\": \"updatePetWithForm\",\n" +
        "        \"parameters\": [\n" +
        "          {\n" +
        "            \"name\": \"petId\",\n" +
        "            \"in\": \"path\",\n" +
        "            \"description\": \"ID of pet that needs to be updated\",\n" +
        "            \"required\": true,\n" +
        "            \"schema\": { \"type\": \"integer\", \"format\": \"int64\" }\n" +
        "          },\n" +
        "          {\n" +
        "            \"name\": \"name\",\n" +
        "            \"in\": \"query\",\n" +
        "            \"description\": \"Name of pet that needs to be updated\",\n" +
        "            \"schema\": { \"type\": \"string\" }\n" +
        "          },\n" +
        "          {\n" +
        "            \"name\": \"status\",\n" +
        "            \"in\": \"query\",\n" +
        "            \"description\": \"Status of pet that needs to be updated\",\n" +
        "            \"schema\": { \"type\": \"string\" }\n" +
        "          }\n" +
        "        ],\n" +
        "        \"responses\": { \"405\": { \"description\": \"Invalid input\" } },\n" +
        "        \"security\": [{ \"petstore_auth\": [\"write:pets\", \"read:pets\"] }]\n" +
        "      },\n" +
        "      \"delete\": {\n" +
        "        \"tags\": [\"pet\"],\n" +
        "        \"summary\": \"Deletes a pet\",\n" +
        "        \"description\": \"\",\n" +
        "        \"operationId\": \"deletePet\",\n" +
        "        \"parameters\": [\n" +
        "          {\n" +
        "            \"name\": \"api_key\",\n" +
        "            \"in\": \"header\",\n" +
        "            \"description\": \"\",\n" +
        "            \"required\": false,\n" +
        "            \"schema\": { \"type\": \"string\" }\n" +
        "          },\n" +
        "          {\n" +
        "            \"name\": \"petId\",\n" +
        "            \"in\": \"path\",\n" +
        "            \"description\": \"Pet id to delete\",\n" +
        "            \"required\": true,\n" +
        "            \"schema\": { \"type\": \"integer\", \"format\": \"int64\" }\n" +
        "          }\n" +
        "        ],\n" +
        "        \"responses\": { \"400\": { \"description\": \"Invalid pet value\" } },\n" +
        "        \"security\": [{ \"petstore_auth\": [\"write:pets\", \"read:pets\"] }]\n" +
        "      }\n" +
        "    },\n" +
        "\n" +
        "    \"/user\": {\n" +
        "      \"post\": {\n" +
        "        \"tags\": [\"user\"],\n" +
        "        \"summary\": \"Create user\",\n" +
        "        \"description\": \"This can only be done by the logged in user.\",\n" +
        "        \"operationId\": \"createUser\",\n" +
        "        \"requestBody\": {\n" +
        "          \"description\": \"Created user object\",\n" +
        "          \"content\": {\n" +
        "            \"application/json\": {\n" +
        "              \"schema\": { \"$ref\": \"#/components/schemas/User\" }\n" +
        "            },\n" +
        "            \"application/xml\": {\n" +
        "              \"schema\": { \"$ref\": \"#/components/schemas/User\" }\n" +
        "            },\n" +
        "            \"application/x-www-form-urlencoded\": {\n" +
        "              \"schema\": { \"$ref\": \"#/components/schemas/User\" }\n" +
        "            }\n" +
        "          }\n" +
        "        },\n" +
        "        \"responses\": {\n" +
        "          \"default\": {\n" +
        "            \"description\": \"successful operation\",\n" +
        "            \"content\": {\n" +
        "              \"application/json\": {\n" +
        "                \"schema\": { \"$ref\": \"#/components/schemas/User\" }\n" +
        "              },\n" +
        "              \"application/xml\": {\n" +
        "                \"schema\": { \"$ref\": \"#/components/schemas/User\" }\n" +
        "              }\n" +
        "            }\n" +
        "          }\n" +
        "        }\n" +
        "      }\n" +
        "    }\n" +
        "  },\n" +
        "  \"components\": {\n" +
        "    \"schemas\": {\n" +
        "      \"User\": {\n" +
        "        \"type\": \"object\",\n" +
        "        \"properties\": {\n" +
        "          \"id\": { \"type\": \"integer\", \"format\": \"int64\", \"example\": 10 },\n" +
        "          \"username\": { \"type\": \"string\", \"example\": \"theUser\" },\n" +
        "          \"firstName\": { \"type\": \"string\", \"example\": \"John\" },\n" +
        "          \"lastName\": { \"type\": \"string\", \"example\": \"James\" },\n" +
        "          \"email\": { \"type\": \"string\", \"example\": \"john@email.com\" },\n" +
        "          \"password\": { \"type\": \"string\", \"example\": \"12345\" },\n" +
        "          \"phone\": { \"type\": \"string\", \"example\": \"12345\" },\n" +
        "          \"userStatus\": {\n" +
        "            \"type\": \"integer\",\n" +
        "            \"description\": \"User Status\",\n" +
        "            \"format\": \"int32\",\n" +
        "            \"example\": 1\n" +
        "          }\n" +
        "        },\n" +
        "        \"xml\": { \"name\": \"user\" }\n" +
        "      },\n" +
        "      \"Tag\": {\n" +
        "        \"type\": \"object\",\n" +
        "        \"properties\": {\n" +
        "          \"id\": { \"type\": \"integer\", \"format\": \"int64\" },\n" +
        "          \"name\": { \"type\": \"string\" }\n" +
        "        },\n" +
        "        \"xml\": { \"name\": \"tag\" }\n" +
        "      },\n" +
        "      \"Pet\": {\n" +
        "        \"required\": [\"name\", \"photoUrls\"],\n" +
        "        \"type\": \"object\",\n" +
        "        \"properties\": {\n" +
        "          \"id\": { \"type\": \"integer\", \"format\": \"int64\", \"example\": 10 },\n" +
        "          \"name\": { \"type\": \"string\", \"example\": \"doggie\" },\n" +
        "          \"photoUrls\": {\n" +
        "            \"type\": \"array\",\n" +
        "            \"xml\": { \"wrapped\": true },\n" +
        "            \"items\": { \"type\": \"string\", \"xml\": { \"name\": \"photoUrl\" } }\n" +
        "          },\n" +
        "          \"tags\": {\n" +
        "            \"type\": \"array\",\n" +
        "            \"xml\": { \"wrapped\": true },\n" +
        "            \"items\": { \"$ref\": \"#/components/schemas/Tag\" }\n" +
        "          },\n" +
        "          \"status\": {\n" +
        "            \"type\": \"string\",\n" +
        "            \"description\": \"pet status in the store\",\n" +
        "            \"enum\": [\"available\", \"pending\", \"sold\"]\n" +
        "          }\n" +
        "        },\n" +
        "        \"xml\": { \"name\": \"pet\" }\n" +
        "      },\n" +
        "      \"ApiResponse\": {\n" +
        "        \"type\": \"object\",\n" +
        "        \"properties\": {\n" +
        "          \"code\": { \"type\": \"integer\", \"format\": \"int32\" },\n" +
        "          \"type\": { \"type\": \"string\" },\n" +
        "          \"message\": { \"type\": \"string\" }\n" +
        "        },\n" +
        "        \"xml\": { \"name\": \"##default\" }\n" +
        "      }\n" +
        "    },\n" +
        "    \"requestBodies\": {\n" +
        "      \"Pet\": {\n" +
        "        \"description\": \"Pet object that needs to be added to the store\",\n" +
        "        \"content\": {\n" +
        "          \"application/json\": {\n" +
        "            \"schema\": { \"$ref\": \"#/components/schemas/Pet\" }\n" +
        "          },\n" +
        "          \"application/xml\": {\n" +
        "            \"schema\": { \"$ref\": \"#/components/schemas/Pet\" }\n" +
        "          }\n" +
        "        }\n" +
        "      },\n" +
        "      \"UserArray\": {\n" +
        "        \"description\": \"List of user object\",\n" +
        "        \"content\": {\n" +
        "          \"application/json\": {\n" +
        "            \"schema\": {\n" +
        "              \"type\": \"array\",\n" +
        "              \"items\": { \"$ref\": \"#/components/schemas/User\" }\n" +
        "            }\n" +
        "          }\n" +
        "        }\n" +
        "      }\n" +
        "    },\n" +
        "    \"securitySchemes\": {\n" +
        "      \"petstore_auth\": {\n" +
        "        \"type\": \"oauth2\",\n" +
        "        \"flows\": {\n" +
        "          \"implicit\": {\n" +
        "            \"authorizationUrl\": \"https://petstore3.swagger.io/oauth/authorize\",\n" +
        "            \"scopes\": {\n" +
        "              \"write:pets\": \"modify pets in your account\",\n" +
        "              \"read:pets\": \"read your pets\"\n" +
        "            }\n" +
        "          }\n" +
        "        }\n" +
        "      },\n" +
        "      \"api_key\": { \"type\": \"apiKey\", \"name\": \"api_key\", \"in\": \"header\" }\n" +
        "    }\n" +
        "  }\n" +
        "}\n", null, options).getOpenAPI();
    Paths paths = openAPI.getPaths();
    ObjectSchema schema;
    if (paths != null) {
        for (String pathname : paths.keySet()) {
            PathItem path = openAPI.getPaths().get(pathname);
            System.out.println("PATH>>>>" +pathname);
//            System.out.println("PATH Reference>>>>>>" +path.get$ref());
            if (path.readOperations() != null) {
                for (Operation operation : path.readOperations()) {
                    System.out.println("Operation Id>>>>>>>:" + operation.getOperationId());
                    if (operation.getRequestBody() != null) {
                        String contentType = new ArrayList<>(operation.getRequestBody().getContent().keySet()).get(0);
                        MediaType mediaType = operation.getRequestBody().getContent().get(contentType);
//                        if (mediaType != null) {
//                            System.out.println("Media Type " + contentType);
//                        }

                            schema = (ObjectSchema) openAPI.getPaths().get(pathname).getPost().getRequestBody().getContent().get(contentType).getSchema();
                            System.out.println("Schema Properties " + schema.getProperties().keySet());





//                        ObjectSchema schema = (ObjectSchema) openAPI.getPaths().get(pathname).getPost().getRequestBody().getContent().get(contentType).getSchema();

//                        System.out.println("Schema: " + mediaType.getSchema().get$ref());
                    }
                    if (operation.getParameters() != null) {
                        System.out.println("Parameters number: " + operation.getParameters().size());
                        for (Parameter parameter : operation.getParameters()) {
                            System.out.println(" - " + parameter.getName());
                        }
                    }


                }
            }
        }

    }
}

}
