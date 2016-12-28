require('JL_HttpTool,NSDictionary,JL_RequestManager,JPUSHService,JL_User,NSNotificationCenter,JL_StatusModel');
defineClass('JL_LoginViewController', {
            requestLogin: function() {
            var reqTime = JL_HttpTool.getRequestTime();
            
            var dic = {
            "chanType": JL_HttpTool.getChanType(),
            "entranceID": JL_HttpTool.getEntranceID(),
            "reqTime": reqTime,
            "sign": JL_HttpTool.getSignWithPhone_withTime(self.phoneFiled().text(), reqTime),
            "loginPhone": self.phoneFiled().text(),
            "passWord": JL_HttpTool.getPassWord(self.passwordFiled().text())
            };
            var sel = self; 
            JL_RequestManager.defaultManager().POST_parameters_progress_success_failure('http://123.56.160.135:9810/gateway2server/basicController/login', dic, null, block('NSURLSessionDataTask*,id', function(task, responseObject) {
                                                                                                                                                                                                                                                                                                                 console.log(responseObject);
                                                                                                                          
                                                                                                                                                                            responseObject = responseObject.toJS();
                                 console.log(responseObject['respMesg']);
                                     if (responseObject['respCode']==045) {
                                                                                                                                                                            console.log('786487236784');

                                                                                                                                                                            JPUSHService.setAlias_callbackSelector_object(sel.phoneFiled().text(), null, null);
                                                                                                                          
                                                                                                                          var user = JL_User.User();
                                                                                                                          user.setUserPhone(sel.phoneFiled().text());
                                                                                                                          user.setPassword(sel.passwordFiled().text());
                                                                                                                          user.setToken(responseObject['token']);
                                                                                                                          user.saveUserInfo();
                                                                                                                          NSNotificationCenter.defaultCenter().postNotificationName_object("QUIT", null);
                                                                                                                          JL_StatusModel.status().clearModel();
                                                                                                                          sel.navigationController().popToRootViewControllerAnimated(YES);
                                                                                                                          
                                                                                                                                                                            }else{
                                               sel.showWithStr(responseObject['respMesg']);
                                            
                                                                                                                                                                            console.log('0000000');

                                                                                                                                                                            }
                                                                                                                          
                                                                                                                          }), block('NSURLSessionDataTask*,NSError*', function(task, error) {
                                                                                                                                    
                                           console.log(error);
                                                                                                                                    }));
            
            
            
            },
            });
