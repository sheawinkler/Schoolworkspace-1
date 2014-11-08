# John Tooker
# February 6, 2011
#
# multiply two numbers and print the result (16 bits)
# the first number is in memory: 0x0555
# the second number comes from the instruction 0x07
#
# $s0 = number 1 high
# $s1 = number 1 low
# $s2 = number 2 high
# $s3 = number 2 low
# $IOB = product high
# $IOA = product low

    .data
number 5 85     # 0x555

    .text
    
main:
    # get the first number (larger - from memory)
    la      number
    movfw   $MAR
    ld      0           # high byte
    movfw   $s0
    ld      1           # low byte
    movfw   $s1
    
    # get the second number
    clrf    $s2
    movl    7
    movfw   $s3
    
    call    multiply
    
exit:
    # nothing to do, but loop so we do not restart
    jump    exit
    
    # multiply loop
multiply:
    # test $s2$s3 to see if it is zero
    clrw
    addf    $s3         # test low
    jne     continue    # low is not zero, continue
    addf    $s2         # low is zero, check high
    jeq     mult_exit   # high is also zero, exit
    
continue:
    # accumulate product:
    movf    $IOA        # load low byte
    addf    $s1         # do addition
    movfw   $IOA        # store low byte (does not change c flag)
    movf    $IOB        # load high byte (does not change c flag)
    addfc   $s0         # do addition (with carry)
    movfw   $IOB
    
    # now decrement counter and repeat
    movf    $s3         # get low byte to w for decrimenting
    addl    -1          # decrement
    movfw   $s3         # store result (does not change c flag)
    #movf    $s2         # get high byte to w for decrimenting
    #clrf    $0          # set $0 so we can subtract with carry using it
    #subfc   $0
    #movfw   $s2         # store result
    movl    -1          # add -1 to low byte, put -1 in W to begin
    addf    $s2         # add high byte with carry to zero
    
    jump    multiply
  
mult_exit:
    ret