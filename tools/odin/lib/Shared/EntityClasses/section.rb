=begin

Copyright 2012-2013 inBloom, Inc. and its affiliates.

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

require_relative "../data_utility.rb"
require_relative "baseEntity.rb"
require_relative "enum/EducationalEnvironmentType.rb"
require_relative "enum/MediumOfInstructionType.rb"
require_relative "enum/PopulationServedType.rb"

# creates section
class Section < BaseEntity

  attr_accessor :school_id, :unique_section_code, :sequence, :environment, 
    :medium, :population, :course_offering, :session,
    :availableCredit, :ed_org_id, :class_period_name

  def initialize(id, school_id, offering, class_period_name, session = offering['session'], program = nil)
    @rand = Random.new(id.hash)
    # move these to choices.yml eventually and have these be a weighted choice
    @sequence = 1  
    @environment = "Classroom"
    @medium = "Face-to-face instruction"
    @population = "Regular Students"
    @school_id = school_id
    @class_period_name = class_period_name
    @course_offering = {code: DataUtility.get_course_offering_code(offering['id']),
                        ed_org_id: offering['ed_org_id'],
                        session: offering['session']}
    @session = offering['session']
    @unique_section_code = DataUtility.get_unique_section_id(id)
    #@program              = program
    # --> programs are not currently implementedS
    @class_period_name = class_period_name
    
    optional {@availableCredit = {
        :credit => @rand.rand(500)/100,
        :creditType => choose([
          "Carnegie unit",
          "Semester hour credit",
          "Trimester hour credit",
          "Quarter hour credit",
          "Nine month year hour credit",
          "Twelve month year hour credit",
          "Other"]),
        :creditConversion => @rand.rand(200)/100
      }
    }
    
  end

  def ed_org_id
    @school_id
  end

end
