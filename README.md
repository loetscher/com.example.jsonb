# com.example.jsonb

Sandbox to verify some challenges for jackson -> jasonb/yasson migration:
* ```genericmap```: Generic HashMap with Integer as Key is not parsed correctly
* ```innerclass```: Innerclass failed to serialize
* ```extendsmap```: subclass of HashMap<String, SomeDto> fails to deserialize

Run all Test and have a look at the failing tests: Test works with Jackson, but fails with JsonB.

See alseo
https://github.com/eclipse-ee4j/jsonb-api/blob/master/spec/src/main/asciidoc/jsonb.adoc#317-generics
https://github.com/eclipse-ee4j/yasson/issues/110
https://github.com/eclipse-ee4j/yasson/issues/177
https://github.com/eclipse-ee4j/yasson/issues/253
https://github.com/eclipse-ee4j/yasson/issues/283
https://github.com/eclipse-ee4j/yasson/issues/505
https://github.com/eclipse-ee4j/yasson/pull/513

