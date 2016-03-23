var exec = require('cordova/exec');

var checkPhone = {
    
    phoneCallsSupported: function (request, successCallback, errorCallback) {
        exec(successCallback, errorCallback, "CheckPhonePlugin", "phoneCallsSupported", [
        		request.phoneNumber
        	]
        );
    }
};

module.exports = checkPhone;