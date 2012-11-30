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
Dir["#{File.dirname(__FILE__)}/../../Shared/EntityClasses/*.rb"].each { |f| load(f) }
class InterchangeGenerator
  @@totalEntityCount = 0

  attr_accessor :interchange, :header, :footer

  def initialize(interchange, batchSize=10000)
    @stime = Time.now
    @entityCount = 0
    @interchange = interchange
    @entities = []
    @batchSize = batchSize
    @writers = Hash.new
    @header = ""
    @footer = ""
  end

  def start()
    @interchange << @header
  end

  def <<(entity)
    @entities << entity
    if @entities.size >= @batchSize
      renderBatch
      @entities = []
    end
  end

  def renderBatch
    report(@entities)

    #filter_entities
    split_entities = @entities.group_by( &:class )

    split_entities.each do |k, v|
      @interchange << (@writers[k].write(v))
    end
  end

  def report(entities)
    @entityCount += entities.length
    @@totalEntityCount += entities.length
    if @@totalEntityCount % 100000 == 0
      puts "\t#@@totalEntityCount entities created."
    end
  end

  def finalize()
    renderBatch

    @interchange << @footer
    @interchange.flush()
    @interchange.close()

    elapsed = Time.now - @stime
    puts "\t#@entityCount written in #{elapsed} seconds."
  end

end
