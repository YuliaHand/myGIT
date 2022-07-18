function fn() {
var env = karate.env; // get system property 'karate.env' karate.log('karate.env system property was:', env);
if (!env) {
env = 'dev';
}

var config = {
env: env,
//myVarName: 'hello karate',
baseUrl: 'http://qa.cilsy.id/symfony/web/index.php',
client_id: 'lia123',
client_secret: '12345',
grant_type: 'client_credentials',
username: 'Admin',
password: 's3Kol4HQA!*'
}

if (env == 'dev') {
// customize
// e.g. config.foo = 'bar';
} else if (env == 'e2e') {
// customize
}
return config;
}