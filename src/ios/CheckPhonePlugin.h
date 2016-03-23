//
//  CheckPhonePlugin.h
//
//  Created by Diego García on 3/22/16.
//
//

#import <Cordova/CDVPlugin.h>

@interface CheckPhonePlugin : CDVPlugin

- (void)phoneCallsSupported:(CDVInvokedUrlCommand*)command;

@end
