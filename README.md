# currency-converter
> **1)** Before starting to use the application locally, a few steps are necessary, which are as follows:
>> **1)** Install Docker (https://docs.docker.com/engine/install/) <br />
>> **2)** With the Docker installed, download the following images: <br />
>>> **2.1)** docker pull mongo <br />
>>> **2.2)** docker pull gradle

>> To run the application, just type in the terminal (NOTE: It must be inside the project's root folder):
>>> **1)** _chmod 744 run.sh_ <br />
>>> **2)** _./run.sh_

> **2)** Structure:
>> The project was designed and built following the DDD, there is a clear division between the project folders, which are:
>>> **1)** config: You are responsible for reading the properties defined in the project (defined in /resources/application.properties). <br />
>>> **2)** util: You are responsible for making any specific treatment that can be reused elsewhere. For example: Date formatting <br />
>>> **3)** transaction: He is responsible for the domain, here the core of the app is concentrated.
>>>> **3.1)** service: He is responsible for the app's business, as well as being an adapter to retrieve the information from the exchange API <br />
>>>> **3.2)** repository: Is responsible for the persistence of information <br />
>>>> **3.3)** json: Responsible for serializing API requests / responses to app objects <br />
>>>> **3.4)** exception: Is responsible for project exceptions <br />
>>>> **3.5)** entity: It is responsible for the classes that are persisted in the bank <br />

>> Ps: Classes that ended up being loose are just as important as the others, but it is worth commenting on:
>>> **1)** TransactionHandler: Responsible for receiving requests <br />
>>> **2)** Route: Responsible for mapping the API routes (URI) <br />
>>> **3)** HandleException: Responsible for mapping the exceptions launched in the app and handling the response to the client <br />
>>> **4)** CurrencyConverterInitializer: Responsible for starting the app

> **3)** Error Handling:
>> In the app there are some exceptions so according to the scenario there is a different answer, let's go to them:
>>> **1)** Status 400 - Mandatory information was not provided <br />
>>> **2)** Status 502 - It was not possible to communicate with the external API for some reason. <br />
>>> **3)** Status 500 - When a server error occurs, such as failure to read the properties file <br />
>>> **4)** Status 422:
>>>> **4.1)** When the source or destination currency entered in the request does not exist in the external API <br />
>>>> **4.2)** When there is no transaction for a given user

> **4)** End-points:
>> **1)** Service with the responsibility of listing all transactions made for a given user
>>> **1.1)** URI(GET): <host.uri>/api?userId=joao'
>>>> **1.1.1)** Response when accessing the end-point above: {
         "userId": "joao",
         "transactions": [
             {
                 "id": "602d24bc3af5cd32f85ff37b",
                 "coin": {
                     "orign": "USD",
                     "target": "BRL"
                 },
                 "value": {
                     "orign": 25,
                     "target": 134.25
                 },
                 "rate": 5.3700897636,
                 "date": "2021-02-17T14:14:20.917Z"
             }
         ]
     }
<br />
>>> **1.1.2)** Description of the fields:
>>>>> **1.1.2.1)** "id" -> Transaction code <br />
>>>>> **1.1.2.2)** "coin.orign" -> Currency of origin; in other words, currency that you want to be used as a basis for conversion <br />
>>>>> **1.1.2.3)** "coin.target" -> Moeda destino; ou seja moeda que deseja ser convertida dado a informação acima<br />
>>>>> **1.1.2.4)** "value.orign" -> Destination currency; in other words, currency that you want to convert given the information above <br />
>>>>> **1.1.2.5)** "value.target" -> This value is calculated according to the conversion rate provided by the external API <br />
>>>>> **1.1.2.6)** "rate" -> The value is taken from the external API <br />
>>>>> **1.1.2.7)** "date" -> Date that a specific user made that particular transaction. <br />

>>> **1.2)** Service with the responsibility of saving the transaction per user:
>>>> **1.2.1)** URI(POST): <host.uri>/api/ -H Content-Type: application/json<br />
>>>> **1.2.2)** Send in the request body:
>{
 	"userId": "TESTEEEEEE",
 	"coin": {
 		"orign": "USD",
 		"target": "BRL"
 	},
 	"value": 25
 }
PS: Field descriptions are the same as in the end-point above <br />

> **5)** Stacks:
>> **5.1)** Programming language: Java<br />
>> **5.2)** Framework: Javalin<br />
>> **5.3)** Database: NoSql(MongoDB)<br />
>> **5.4)** DevOps: GitHub Actions(CI/CD), Docker(Container), Heroku(Cloud)<br />

Ps: The app considers all conversions provided by the exchange API.