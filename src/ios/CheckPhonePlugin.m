#import "CheckPhonePlugin.h"
#import <Cordova/CDVPluginResult.h>


@implementation CheckPhonePlugin

- (void)phoneCallsSupported:(CDVInvokedUrlCommand*)command
{
    BOOL success = true;
    BOOL isSupported =[[UIApplication sharedApplication] canOpenURL:[NSURL URLWithString:@"tel://"]];
	NSDictionary* successResult = [ [NSDictionary alloc]
                                  initWithObjectsAndKeys:
                                  [NSNumber numberWithBool:success], @"success",
                                   [NSNumber numberWithBool:isSupported], @"phoneCallsSupported",
                                  nil
                                  ];

    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary:successResult];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
