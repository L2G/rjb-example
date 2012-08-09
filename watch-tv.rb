require 'rjb'

PKG = 'com.github.L2G.rjb_example'
Rjb.load('bin')

CableBox = Rjb.import("#{PKG}.CableBox")

# This will have the Java interface IDisplayDevice bound to it.
# A CableBox will react to its channelUp method by finding the next
# program to show and calling showProgram on whatever object it has
# that implements IDisplayDevice.
class Television
   def initialize
      $stdout.puts "Television: newly set up, not showing anything"
   end
   
   def showProgram(program)
      $stdout.puts "Television: now showing #{program.getName}"
   end
end

tv = Rjb.bind(Television.new, "#{PKG}.IDisplayDevice")
box = CableBox.new(tv)

10.times do
   sleep(rand()*8)
   box.channelUp
end
