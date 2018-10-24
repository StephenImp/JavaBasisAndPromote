完全解耦

partTwo创建类的顺序：
    Waveform   Filter   LowPass   HighPass   BandPass

    这是个什么捏，看不懂。

    Filter与Processor具有相同的接口元素，但因为它并非继承自但因为它并非继承自Processor
    因为Filter类的创建者压根不清楚你想要将它用作Processor

    因此不能将Filter用于Apply.process()方法，及时这样做可以正常运行。
    这里主要是因为Apply.process()方法和Processor之间的耦合过紧，已经超出了所需要的程度，
    这就使得应该复用Apply.process()的代码时，复用却被禁止了。
    另外还需要注意的是它们的输入和输出都是Waveform。

    但是，如果Processor是一个接口，那么这些限制就会变得松动，使得你可以复用结构该接口的Apply.process()


    解决--->complete
