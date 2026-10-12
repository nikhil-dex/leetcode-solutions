class MedianFinder {
    PriorityQueue<Double> g;
    PriorityQueue<Double> s;
   
    public MedianFinder() {
        g = new PriorityQueue<>();
        s = new PriorityQueue<>(Collections.reverseOrder());
     
    
     
    }
    
    public void addNum(int num) {
       s.add((double)num);
       g.add(s.poll());
       if(s.size()<g.size()){
        s.add(g.poll());
       }

    }
    
    public double findMedian() {
        if(s.size()>g.size()){
            return s.peek();
        }
        return (s.peek()+g.peek())/2.0;
     
    
        
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */