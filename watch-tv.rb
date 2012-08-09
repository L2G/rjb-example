require 'rjb'

PKG = 'com.github.L2G.rjb_example'
Rjb.load('bin')

CableBox = Rjb.import("#{PKG}.CableBox")

# This will have the Java interface IDisplayDevice bound to it.
class Television
   def showProgram(string)
      $stdout.puts "Television: now showing #{string}"
   end
end

tv = Rjb.bind(Television.new, "#{PKG}.IDisplayDevice")
box = CableBox.new(tv)

10.times do
   sleep(rand()*8)
   box.channelUp
end
