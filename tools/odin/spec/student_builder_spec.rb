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
#require_relative 'spec_helper'
require_relative '../lib/EntityCreation/student_builder.rb'
require_relative '../lib/Shared/demographics.rb'

describe "StudentBuilder" do
  describe "#build" do
    context "With new student credentials" do
      let(:new_id) {52}
      let(:newDemographics) {Demographics.new}
      let(:newRand) {Random.new(new_id)}
      let(:newBirthDay) {Date.new(1999, 1, 12)}
      let(:newStudent) {Student.new(new_id, newBirthDay, newDemographics, newRand)}

      it "will choose gender" do
        newStudent.sex.should match(/^Male|^Female/)
      end

      it "will generate a consistent pseudorandom Birthdate" do
        newStudent.birthDay.to_s.should match(/1999-06-17/)
      end

      it "will match the state in choices.yml" do
        newStudent.state.should eq("NY")
      end
      
      it "will match the city in choices.yml" do
        newStudent.city.should eq("New York")
      end

      it "will match the HARDCODED zip code"  do
        newStudent.postalCode.should eq("10292")
      end

      it "should generate email addresses that end in fakemail.com" do
        newStudent.email.should match(/@fakemail.com/)
      end

      it "should return a boolean value for disability" do
        newStudent.disability.should_not be_nil
      end

      it "returns 55-65% white with white weighted distribution set to 60%" do
        i = 0
        hit = 0
        while i < 1000 do
          retVal = newStudent.genRace
          if retVal == "White"
            hit += 1
          end
          i += 1
        end
        if hit.between?(550, 650)
          puts "THE HIT RATIO WAS WITHIN EXPECTED VALUES! YAY!"
          puts "Want the know specifics? White came back #{hit} times out of 1000."
          ret = "true"
        else
          ret = "false"
        end
        ret.should eq("true")
      end
      
      it "returns 15-25% hispanicLatino true" do
        i = 0
        hit = 0
        while i < 1000 do
          retVal = newStudent.hispanicLatino
          if retVal
            hit += 1
          end
          i += 1
        end
        if hit.between?(150, 250)
          puts "THE HIT RATIO WAS WITHIN EXPECTED VALUES! YAY!"
          puts "Want the know specifics? hispanicLatino came back #{hit} times out of 1000."
          ret = "true"
        else
          ret = "false"
        end
        ret.should eq("true")        
      end
    end        
        
        
    context 'With a simple work order' do
      let(:work_order) {{:id => 42, :sessions => [{:school => 64, :sections => [{:id => 32, :edOrg => 64},
                                                                                  {:id => 33, :edOrg => 64},
                                                                                  {:id => 34, :edOrg => 128}]},
                                                    {:school => 65, :sections => [{:id => 16, :edOrg => 65},
                                                                                  {:id => 17, :edOrg => 65}]}],
                         :demographics => Demographics.new, :birth_day_after => Date.new(2000, 9, 1)}}
      let(:studentParent) {StringIO.new('', 'w')}
      let(:enrollment) {StringIO.new('', 'w')}
      let(:builder) {StudentBuilder.new(work_order, {:studentParent => studentParent, :enrollment => enrollment})}
      before {builder.build}

      it "will build student documents with the given student id" do
        studentParent.string.match('<StudentUniqueStateId>42</StudentUniqueStateId>').should_not be_nil
      end

      it "will have the right number of schools associations" do
        enrollment.string.lines.select{|l| l.match('<StudentSchoolAssociation>')}.length.should eq(2)
      end

      it "will have the right number of section associations" do
        enrollment.string.lines.select{|l| l.match('<StudentSectionAssociation>')}.length.should eq(5)
      end

      it "will find a school with the correct school ids" do
        work_order[:sessions].each do |session|
          school_id = session[:school]
          enrollment.string.match("<StateOrganizationId>school#{school_id}</StateOrganizationId>").should_not be_nil
        end
      end
    end
  end
end
