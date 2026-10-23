class Solution {
    public String addBinary(String a, String b) {
         int n = a.length()-1;
        int j = b.length()-1;
        if(n>=j){
            return sum(a,b,n,j);
        }
        return sum(b,a,j,n);
        
    }
    public static String sum(String a,String b,int n,int j){
        char carry = '0';
        StringBuilder sb = new StringBuilder();
       
        for(int i=n;i>=0;i--){
            char ab = a.charAt(i);
            char bb;
            if(j>=0){
              bb = b.charAt(j);

              if(bb=='1' && ab=='1'){
                if(carry=='1'){
                  sb.append('1');
                }else{
                    sb.append('0');
                    carry = '1';
                }
              }else if(bb=='0' && ab=='0'){
                sb.append(carry);
                carry = '0';
              }else if(bb=='0' && ab=='1'){
                if(carry=='1'){
                    sb.append('0');
                }else{
                    sb.append(ab);
                }
              }else{
                if(carry=='1'){
                    sb.append('0');
                }else{
                    sb.append(bb);
                }
              }
              j--;
            }else{
                if(ab=='1' && carry=='1'){
                    sb.append('0');
                   
                }else if(ab=='0' && carry=='0'){
                    sb.append('0');
                    
                }else if(ab=='1' && carry=='0'){
                    sb.append(ab);
                }else{
                    sb.append(carry);
                    carry = '0';
                }
            }

        }
        if(carry=='1'){
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}