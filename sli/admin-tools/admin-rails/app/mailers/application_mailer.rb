=begin

Copyright 2012 Shared Learning Collaborative, LLC

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

=end


class ApplicationMailer < ActionMailer::Base
  default from: "#{APP_CONFIG['email_sender_name']} <#{APP_CONFIG['email_sender_address']}>"

  WELCOME_EMAIL_SUBJECT_PROD = "Welcome to the Shared Learning Collaborative"
  WELCOME_EMAIL_SUBJECT_SANDBOX = "Welcome to the SLC Developer Sandbox"
  VERIFY_EMAIL_SUBJECT_SANDBOX ="Shared Learning Collaborative Developer Sandbox Account - Email Confirmation"
  VERIFY_EMAIL_SUBJECT_PROD = "Shared Learning Collaborative Developer Account - Email Confirmation"
  PROVISION_EMAIL_SUBJECT_SANDBOX = "SLC Sandbox Developer - Data Setup"
  PROVISION_EMAIL_SUBJECT_PROD = "Shared Learning Collaborative Landing Zone Setup"
  PASSWORD_CHANGE_SUBJECT = "SLC Notification - Password Changed"
  FORGOT_PASSWORD_SUBJECT = "SLC Notification - Forgot Password"

  def welcome_email(user)
    @firstName = user[:first]
    #@landing_zone_link = "#{APP_CONFIG['email_replace_uri']}/landing_zone"
    @portal_link = APP_CONFIG["portal_url"]
    @documentation_link = APP_CONFIG['sample_data_url']
    #@apps_link = "#{APP_CONFIG['email_replace_uri']}/apps"
    mail(:to => user[:emailAddress], :subject => (APP_CONFIG["is_sandbox"]?WELCOME_EMAIL_SUBJECT_SANDBOX : WELCOME_EMAIL_SUBJECT_PROD))
  end

  def notify_password_change(email_address, fullName)
    @fullName = fullName
    mail(:to => email_address, :subject => PASSWORD_CHANGE_SUBJECT )
  end
  
  def notify_reset_password(email, key)
    user = APP_LDAP_CLIENT.read_user(email)
    @fullName = user[:first] + " " + user[:last]
    @resetPasswordUrl = APP_CONFIG['email_replace_uri'] + "/resetPassword?key=" + key
    mail(:to => 'vummalaneni@wgen.net', :subject => FORGOT_PASSWORD_SUBJECT )
  end
  
  def verify_email(email_address, firstName, userEmailValidationLink)
    @firstName = firstName
    @userEmailValidationLink=userEmailValidationLink
    @supportEmail=APP_CONFIG["support_email"]
    mail(:to => email_address, :subject => (APP_CONFIG["is_sandbox"]?VERIFY_EMAIL_SUBJECT_SANDBOX : VERIFY_EMAIL_SUBJECT_PROD))
  end
  
  def provision_email(email_address, firstName, serverName, edorgId)
    @firstName = firstName
    @serverName = serverName
    @edorgId = edorgId
    @sample_data_link = APP_CONFIG['sample_data_url']
    @redirect_email = APP_CONFIG['redirect_slc_url']
    mail(:to => email_address, :subject => (APP_CONFIG["is_sandbox"]?PROVISION_EMAIL_SUBJECT_SANDBOX : PROVISION_EMAIL_SUBJECT_PROD))
  end
  
  def notify_operator(support_email, app, first_name, dev_name)
    @portal_link = "#{APP_CONFIG['portal_url']}/web/guest/admin"
    @firstName = first_name
    @dev_name = dev_name
    @app = app
    if !@app.nil? and support_email =~ /(\w|-)+@\w+\.\w+/
      mail(:to => support_email, :subject => 'SLC - New Application Notification')
    end
  end
  
  def notify_developer(app, first_name)
    logger.debug {"Mailing to: #{app.metaData.createdBy}"}
    @portal_link = "#{APP_CONFIG['portal_url']}/web/guest/admin"
    @firstName = first_name
    @app = app
    if !@app.nil? and @app.metaData.createdBy =~ /(\w|-)+@\w+\.\w+/
      mail(:to => app.metaData.createdBy, :subject => 'SLC - Your Application Is Approved')
    end
  end
end
